#!/usr/bin/env bash

curl -L -s -o wlp.zip "https://public.dhe.ibm.com/ibmdl/export/pub/software/openliberty/runtime/beta/2020-10-14_1215/openliberty-jakartaee9-20.0.0.12-beta.zip"
unzip -q wlp.zip
cp .travis/wlp-server-template.xml wlp/templates/servers/defaultServer/server.xml
export LIBERTY_HOME="$(cd ./wlp/ && pwd)"
