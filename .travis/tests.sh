#!/usr/bin/env bash

set -euo pipefail

GLASSFISH_URL="http://download.eclipse.org/glassfish/web-5.1.0.zip"
WILDFLY_URL="https://download.jboss.org/wildfly/15.0.1.Final/wildfly-15.0.1.Final.tar.gz"
LIBERTY_URL="https://public.dhe.ibm.com/ibmdl/export/pub/software/websphere/wasdev/downloads/wlp/19.0.0.1/wlp-webProfile8-19.0.0.1.zip"

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

elif [ "${1}" == "tck-glassfish" ]; then

  curl -L -s -o glassfish5.zip "${GLASSFISH_URL}"
  unzip -q glassfish5.zip
  mvn -B -V -DskipTests clean install
  glassfish5/bin/asadmin start-domain
  sleep 30
  pushd tck
  mvn -B -V -Dtck-env=glassfish verify
  popd
  glassfish5/bin/asadmin stop-domain

elif [ "${1}" == "tck-wildfly" ]; then

  curl -L -s -o wildfly.tgz "${WILDFLY_URL}"
  tar -xzf wildfly.tgz
  mvn -B -V -DskipTests clean install
  LAUNCH_JBOSS_IN_BACKGROUND=1 JBOSS_PIDFILE=wildfly.pid ./wildfly-15.0.1.Final/bin/standalone.sh > wildfly.log 2>&1 &
  sleep 30
  pushd tck
  mvn -B -V -Dtck-env=wildfly verify
  popd
  kill $(cat wildfly.pid)

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
