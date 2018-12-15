#!/usr/bin/env sh

set -eu

docker pull jboss/wildfly:14.0.1.Final
docker run --name=wildfly -d -p 8080:8080 -p 9990:9990 -it jboss/wildfly /opt/jboss/wildfly/bin/standalone.sh -bmanagement 0.0.0.0 -b 0.0.0.0
docker exec wildfly /opt/jboss/wildfly/bin/add-user.sh admin wildfly
