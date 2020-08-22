#!/usr/bin/env bash

curl -L -s -o glassfish5.zip "http://download.eclipse.org/glassfish/web-5.1.0.zip"
unzip glassfish5.zip
glassfish5/bin/asadmin start-domain
