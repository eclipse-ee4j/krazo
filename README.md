[![Build Status](https://travis-ci.org/eclipse-ee4j/krazo.svg?branch=master)](https://travis-ci.org/eclipse-ee4j/krazo)

# Eclipse Krazo

Eclipse Krazo is an implementation of action-based MVC specified by Jakarta MVC 2.0. It builds on top of Jakarta RESTful Webservices 
and currently contains support for RESTEasy, Jersey and CXF with a well-defined SPI for other implementations.

## Running the testsuite

Eclipse Krazo has configurations to run the testsuite against a bunch of application servers like WildFly, Payara, Glassfish or Liberty.
The following sections describe how you test Eclipse Krazo against them. At the moment, we test against following servers:

- Glassfish 8
- WildFly 22.x.x
- TomEE 10.x
- OpenLiberty 20.0.0.12

### Preconditions
- JDK 11
- SNAPSHOTs are up to date in your local repository

### Glassfish
To run the Krazo testsuite with Eclipse Glassfish, you need to follow these steps:

1. Download Eclipse Glassfish from the [official download page](https://glassfish.org/download) and unzip it.
2. Start Eclipse Glassfish via `glassfish6/glassfish/bin/startserv`
3. Go into the `testsuite` package of Eclipse Krazo and execute `mvn clean integration-test -Ptestsuite-glassfish`

### WildFly
To run the Krazo testsuite with WildFly, you need to follow these steps:

1. Download WildFly from the WildFly [download page](https://wildfly.org/downloads/) and unzip it somewhere you'll find it again.
2. Start WildFly with `sh standalone.sh --debug`. This enables you to remote-debug the Arquillian tests.
3. Go into the `testsuite` package of Eclipse Krazo and execute `mvn clean integration-test -Ptestsuite-wildfly`

### TomEE
To run the Krazo testsuite with TomEE, you need to follow these steps:
1. Download TomEE from the TomEE [download page](https://tomee.apache.org/download-ng.html) and unzip it somewhere you'll find it again.
2. Overwrite or enable the following settings in `${TOMEE_HOME}/conf/system.properties` to get Arquillian to run:
```
tomee.remote.support=true
tomee.serialization.class.blacklist=-
openejb.system.apps = true
```
3. Start TomEE with `sh catalina.sh jpda start`. This enables you to remote-debug the Arquillian tests.
4. Go into the `testsuite` package of Eclipse Krazo and execute `mvn clean integration-test -Ptestsuite-tomee`

### OpenLiberty
To run the Krazo testsuite with OpenLiberty, you need to follow these steps. Please note that this process has been tested with 20.x only.

1. Download OpenLiberty from the [official download page](https://openliberty.io/downloads/) and unzip it.
2. Replace the file `wlp/templates/servers/defaultServer/server.xml` with `.travis/wlp-server-template.xml` from the Eclipse Krazo repository.
3. Go into the `testsuite` package of Eclipse Krazo and execute `mvn clean integration-test -Ptestsuite-glassfish -Dliberty.home=c:/somewhere/wlp/`.
   Please make sure to replace `c:/somewhere/wlp/` with the absolute path to the unpacked OpenLiberty distribution.

### Troubleshooting

#### Tests are failing locally but not in Jenkins
In this case, ensure that your local SNAPSHOTS are the newest version of Krazo. Most of time, this solves the problem.
