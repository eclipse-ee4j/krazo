#!/usr/bin/env sh

set -eu

docker run --name=payara -d -p 8080:8080 -p 4848:4848 -it payara/server-web:5.2020.3

# Payara uses a self signed certificate for the management-api.
# The certificate is generated during the release and differs for every version.
# We need to put the certificate in the java truststore for the arquillian tests.

sudo keytool -import -noprompt \
    -file testsuite/src/test/resources/payara.pem \
    -alias Payara \
    -keystore ${JAVA_HOME}/jre/lib/security/cacerts \
    -storepass changeit

# The certificate has to be updated after every payara update. Here's how to do it:
# Run the docker container using the statement above. The run:
#
# openssl s_client -connect localhost:4848 | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > src/test/resources/payara.pem

