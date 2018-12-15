#!/usr/bin/env sh

set -eu

docker pull payara/server-web:5.183
docker run --name=payara -d -p 8080:8080 -p 4848:4848 -it payara/server-web:5.183
