#!/usr/bin/env sh

WILDFLY_VERSION=20.0.1.Final
set -eu

docker pull jboss/wildfly:$WILDFLY_VERSION
docker run --name=wildfly -d -p 8080:8080 -p 9990:9990 -it jboss/wildfly:$WILDFLY_VERSION /opt/jboss/wildfly/bin/standalone.sh -bmanagement 0.0.0.0 -b 0.0.0.0
docker exec wildfly /opt/jboss/wildfly/bin/add-user.sh admin wildfly
