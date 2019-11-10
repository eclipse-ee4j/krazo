#!/usr/bin/env bash

set -euo pipefail

GLASSFISH_URL="http://download.eclipse.org/glassfish/web-5.1.0.zip"
WILDFLY_URL="https://download.jboss.org/wildfly/18.0.0.Final/wildfly-18.0.0.Final.zip"
LIBERTY_URL="https://public.dhe.ibm.com/ibmdl/export/pub/software/websphere/wasdev/downloads/wlp/19.0.0.11/wlp-webProfile8-19.0.0.11.zip"

if [ "${1}" == "glassfish-bundled" ]; then

  curl -L -s -o glassfish5.zip "${GLASSFISH_URL}"
  unzip -q glassfish5.zip
  mvn -B -V -Pbundled clean install
  find ./examples/ -name \*.war -exec cp {} ./glassfish5/glassfish/domains/domain1/autodeploy/ \;
  glassfish5/bin/asadmin start-domain
  sleep 120
  mvn -Pintegration -Dintegration.serverPort=8080 verify
  glassfish5/bin/asadmin stop-domain

elif [ "${1}" == "glassfish-module" ]; then

  curl -L -s -o glassfish5.zip "${GLASSFISH_URL}"
  unzip -q glassfish5.zip
  mvn -B -V -P\!bundled,module clean install
  cp core/target/krazo-core-*.jar ./glassfish5/glassfish/modules/
  cp jersey/target/krazo-jersey-*.jar ./glassfish5/glassfish/modules/
  cp ~/.m2/repository/javax/mvc/javax.mvc-api/1.0-pfd/*.jar ./glassfish5/glassfish/modules/
  find ./examples/ -name \*.war -exec cp {} ./glassfish5/glassfish/domains/domain1/autodeploy/ \;
  glassfish5/bin/asadmin start-domain
  sleep 120
  mvn -Pintegration -Dintegration.serverPort=8080 verify
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
  mvn -B -V -DskipTests clean install

  echo "Starting Glassfish..."
  glassfish5/bin/asadmin start-domain
  sleep 30

  echo "Running TCK..."
  pushd tck
  mvn -B -V -Dtck-env=glassfish verify
  popd

  echo "Stopping Glassfish..."
  glassfish5/bin/asadmin stop-domain

elif [[ ${1} == tck-wildfly18* ]]; then

  echo "Downloading Wildfly..."
  curl -L -s -o wildfly-18.0.0.Final.zip $WILDFLY_URL
  unzip wildfly-18.0.0.Final.zip
  mv wildfly-18.0.0.Final wildfly

  echo "Building Krazo..."
  mvn -B -V -DskipTests clean install

  echo "Starting Wildfly..."
  LAUNCH_JBOSS_IN_BACKGROUND=1 JBOSS_PIDFILE=wildfly.pid ./wildfly/bin/standalone.sh > wildfly.log 2>&1 &
  sleep 30

  echo "Running TCK..."
  pushd tck
  mvn -B -V -Dtck-env=wildfly verify
  popd

  echo "Stopping Wildfly..."
  kill "$(cat wildfly.pid)"

elif [ "${1}" == "tck-tomee" ]; then

  mvn -B -V -DskipTests clean install
  pushd tck
  mvn -B -V -Dtck-env=tomee verify
  popd

elif [ "${1}" == "tck-liberty" ]; then

  curl -L -s -o wlp.zip "${LIBERTY_URL}"
  unzip wlp.zip
  cp .travis/wlp-server-template.xml wlp/templates/servers/defaultServer/server.xml
  LIBERTY_HOME="$( cd ./wlp/ && pwd )"
  mvn -B -V -DskipTests clean install
  pushd tck
  mvn -B -V -Dtck-env=liberty -Dliberty.home=${LIBERTY_HOME} verify
  popd

else
  echo "Unknown test type: $1"
  exit 1;
fi
