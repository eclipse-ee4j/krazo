#!/usr/bin/env sh

set -eu

TOMEE_VERSION=11-jre-8.0.2-plus

docker pull tomee:${TOMEE_VERSION}
docker run --name=tomee -d \
    -p 8080:8080 \
    -e CATALINA_OPTS="\
        -Dtomee.serialization.class.blacklist=- \
        -Dtomee.remote.support=true \
        -Dopenejb.system.apps=true" \
    tomee:${TOMEE_VERSION}
