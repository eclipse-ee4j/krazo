[![Build Status](https://travis-ci.org/eclipse-ee4j/krazo.svg?branch=master)](https://travis-ci.org/eclipse-ee4j/krazo)

# Eclipse Krazo

Eclipse Krazo is an implementation of action-based MVC specified by MVC 1.0 (JSR-371). It builds on top of JAX-RS 
and currently contains support for RESTEasy, Jersey and CXF with a well-defined SPI for other implementations.

## Running the testsuite

Eclipse Krazo has configurations to run the testsuite against a bunch of application servers like WildFly, Payara, Glassfish or Liberty.
The following sections describe how you test Eclipse Krazo against them.

### Preconditions
- JDK 8
- SNAPSHOTs are up to date in your local repository

### WildFly
To run the Krazo testsuite with WildFly, you need to follow these steps:

1. Download WildFly from the WildFly [download page](https://wildfly.org/downloads/) and unzip it somewhere you'll find it again.
2. Start WildFly with `sh standalone.sh --debug`. This enables you to remote-debug the Arquillian tests.
3. Go into the `testsuite` package of Eclipse Krazo and execute `mvn clean integration-test -Ptestsuite-wildfly`

### Troubleshooting

#### Tests are failing locally but not on Travis CI
In this case, ensure that your local SNAPSHOTS are the newest version of Krazo. Most of time, this solves the problem.