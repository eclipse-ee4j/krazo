#!/usr/bin/env sh

set -eu

docker run --name=payara -d -p 8080:8080 -p 4848:4848 -it payara/server-web:5.191

# Payara uses a self signed certificate for the management-api.
# The certificate is generated during the release and differs for every version.
# We get the certificate and put it in the truststore used during the arquillian tests.

# The certificate has to be updated after every payara update. Here's how to do it:
# Run the docker container using the statement above. The run:

# openssl s_client -connect localhost:4848 | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > payara.pem
# keytool -delete -alias Payara -keystore testsuite/src/test/resources/payara-truststore.jks -storepass changeit
# keytool -import -file payara.pem -alias Payara -keystore testsuite/src/test/resources/payara-truststore.jks -storepass changeit

# This only works with the Java 8 Keytool!
