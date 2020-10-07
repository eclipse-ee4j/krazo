#!/usr/bin/env bash

set -euo pipefail

GLASSFISH_URL="http://download.eclipse.org/glassfish/web-5.1.0.zip"
WILDFLY_URL="https://download.jboss.org/wildfly/18.0.0.Final/wildfly-18.0.0.Final.zip"
#BUILD_PROFILE=""
BUILD_PROFILE="-Pstaging"

if [ "${1}" == "glassfish-bundled" ]; then

  curl -L -s -o glassfish5.zip "${GLASSFISH_URL}"
  unzip -q glassfish5.zip
  mvn -B -V -Pbundled clean install ${BUILD_PROFILE}
  find ./examples/ -name \*.war -exec cp {} ./glassfish5/glassfish/domains/domain1/autodeploy/ \;
  glassfish5/bin/asadmin start-domain
  sleep 120
  mvn -Pintegration -Dintegration.serverPort=8080 verify ${BUILD_PROFILE}
  glassfish5/bin/asadmin stop-domain

elif [ "${1}" == "glassfish-module" ]; then

  curl -L -s -o glassfish5.zip "${GLASSFISH_URL}"
  unzip -q glassfish5.zip
  mvn -B -V -P\!bundled,module clean install ${BUILD_PROFILE}
  cp core/target/krazo-core-*.jar ./glassfish5/glassfish/modules/
  cp jersey/target/krazo-jersey-*.jar ./glassfish5/glassfish/modules/
  cp ~/.m2/repository/javax/mvc/javax.mvc-api/1.0.0/*.jar ./glassfish5/glassfish/modules/
  find ./examples/ -name \*.war -exec cp {} ./glassfish5/glassfish/domains/domain1/autodeploy/ \;
  glassfish5/bin/asadmin start-domain
  sleep 120
  mvn -Pintegration -Dintegration.serverPort=8080 verify ${BUILD_PROFILE}
  glassfish5/bin/asadmin stop-domain

elif [[ ${1} == tck-glassfish51-* ]]; then

  echo "Downloading Glassfish..."
  curl -L -s -o glassfish5.zip "${GLASSFISH_URL}"
  unzip -q glassfish5.zip

  if [[ ${1} == *-patched ]]; then
    echo "Patching Glassfish..."
    curl -L -s -o glassfish5/glassfish/modules/jersey-cdi1x.jar \
      "https://www.dropbox.com/s/wc2ukjns388lwir/jersey-cdi1x-2.28-fix1.jar"
    curl -L -s -o glassfish5/glassfish/modules/jersey-common.jar \
      "https://www.dropbox.com/s/qgms27wxlpxw74x/jersey-common-2.28-fix1.jar"
  fi

  echo "Building Krazo..."
  mvn -B -V -DskipTests clean install ${BUILD_PROFILE}

  echo "Starting Glassfish..."
  glassfish5/bin/asadmin start-domain
  sleep 30

  echo "Running TCK..."
  pushd tck
  mvn -B -V -Dtck-env=glassfish verify ${BUILD_PROFILE}
  popd

  echo "Stopping Glassfish..."
  glassfish5/bin/asadmin stop-domain

elif [[ ${1} == tck-wildfly18* ]]; then

  echo "Downloading Wildfly..."
  curl -L -s -o wildfly-18.0.0.Final.zip $WILDFLY_URL
  unzip wildfly-18.0.0.Final.zip
  mv wildfly-18.0.0.Final wildfly

  echo "Building Krazo..."
  mvn -B -V -DskipTests clean install ${BUILD_PROFILE}

  echo "Starting Wildfly..."
  LAUNCH_JBOSS_IN_BACKGROUND=1 JBOSS_PIDFILE=wildfly.pid ./wildfly/bin/standalone.sh > wildfly.log 2>&1 &
  sleep 30

  echo "Running TCK..."
  pushd tck
  mvn -B -V -Dtck-env=wildfly verify ${BUILD_PROFILE}
  popd

  echo "Stopping Wildfly..."
  kill "$(cat wildfly.pid)"

elif [[ ${1} == tck-wildfly19* ]]; then

  echo "Downloading Wildfly..."
  curl -L -s -o wildfly-19.0.0.Beta1.zip https://download.jboss.org/wildfly/19.0.0.Beta1/wildfly-19.0.0.Beta1.zip
  unzip wildfly-19.0.0.Beta1.zip
  mv wildfly-19.0.0.Beta1 wildfly

  echo "Building Krazo..."
  mvn -B -V -DskipTests clean install ${BUILD_PROFILE}

  echo "Starting Wildfly..."
  LAUNCH_JBOSS_IN_BACKGROUND=1 JBOSS_PIDFILE=wildfly.pid ./wildfly/bin/standalone.sh > wildfly.log 2>&1 &
  timeout 30 tail -F wildfly.log || true

  echo "Running TCK..."
  pushd tck
  mvn -B -V -Dtck-env=wildfly verify ${BUILD_PROFILE}
  popd

  echo "Stopping Wildfly..."
  kill "$(cat wildfly.pid)"

elif [ "${1}" == "tck-tomee" ]; then

  mvn -B -V -DskipTests clean install ${BUILD_PROFILE}
  pushd tck
  mvn -B -V -Dtck-env=tomee verify ${BUILD_PROFILE}
  popd

elif [ "${1}" == "tck-liberty" ]; then

  source .travis/install-liberty.sh
  mvn -B -V -DskipTests clean install ${BUILD_PROFILE}
  pushd tck
  mvn -B -V -Dtck-env=liberty -Dliberty.home=${LIBERTY_HOME} verify ${BUILD_PROFILE}
  popd

elif [[ ${1} == testsuite-wildfly ]]; then

   source .travis/docker-wildfly.sh
   echo "Building Krazo..."
   mvn -B -V -DskipTests clean install ${BUILD_PROFILE}
   echo "Running test suite on Wildfly"
   mvn -P${TYPE} --projects testsuite clean verify ${BUILD_PROFILE}

elif [[ ${1} == testsuite-payara ]]; then

   source .travis/docker-payara.sh
   echo "Building Krazo..."
   mvn -B -V -DskipTests clean install ${BUILD_PROFILE}
   echo "Running test suite on Payara"
   mvn -P${TYPE} --projects testsuite clean verify ${BUILD_PROFILE}

elif [[ ${1} == testsuite-tomee ]]; then

   source .travis/docker-tomee.sh
   echo "Building Krazo..."
   mvn -B -V -DskipTests clean install ${BUILD_PROFILE}
   echo "Running test suite on TomEE"
   mvn -P${TYPE} --projects testsuite clean verify ${BUILD_PROFILE}

elif [[ ${1} == testsuite-liberty ]]; then

   source .travis/install-liberty.sh && mvn -P${TYPE} -Dliberty.home=${LIBERTY_HOME} --projects testsuite clean verify ${BUILD_PROFILE}
   echo "Building Krazo..."
   mvn -B -V -DskipTests clean install ${BUILD_PROFILE}
   echo "Running test suite on Liberty"
   mvn -P${TYPE} -Dliberty.home=${LIBERTY_HOME} --projects testsuite clean verify ${BUILD_PROFILE}

else
  echo "Unknown test type: $1"
  exit 1;
fi
