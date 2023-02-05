![Jenkins](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fci.eclipse.org%2Fkrazo%2Fjob%2Fkrazo-ci%2Fjob%2Fmaster%2F)

# Eclipse Krazo

Eclipse Krazo is an implementation of action-based MVC specified by Jakarta MVC 2.0. It builds on top of Jakarta RESTful Webservices 
and currently contains support for RESTEasy and Jersey with a well-defined SPI for other implementations.

## Running the testsuite

Eclipse Krazo has configurations to run the testsuite against a bunch of application servers like WildFly, Payara, Glassfish or Liberty.
The following sections describe how you test Eclipse Krazo against them. At the moment, we test against following servers:

- Glassfish 7.x.x
- WildFly 27.x.x
- OpenLiberty 22.* Beta

### Preconditions
- JDK 11
- SNAPSHOTs are up to date in your local repository

### Glassfish
To run the Krazo testsuite with Eclipse Glassfish, you need to follow these steps:

1. Download Eclipse Glassfish from the [official download page](https://glassfish.org/download) and unzip it.
2. Start Eclipse Glassfish via `glassfish6/glassfish/bin/startserv`
3. Go into the `testsuite` package of Eclipse Krazo and execute `mvn clean integration-test -Ptestsuite-glassfish`

### WildFly
To run the Krazo testsuite with WildFly, you need to run `testsuite-wildfly-managed` or follow these steps:

1. Download WildFly from the WildFly [download page](https://wildfly.org/downloads/) and unzip it somewhere you'll find it again.
2. Start WildFly with `sh standalone.sh --debug`. This enables you to remote-debug the Arquillian tests.
3. Go into the `testsuite` package of Eclipse Krazo and execute `mvn clean integration-test -Ptestsuite-wildfly`

### OpenLiberty
To run the Krazo testsuite with OpenLiberty, you just need to run `mvn verify -P testsuite-liberty-managed`. Maven
will download and configure an instance of OpenLiberty for you.

### Troubleshooting

#### Tests are failing locally but not in Jenkins
In this case, ensure that your local SNAPSHOTS are the newest version of Krazo. Most of time, this solves the problem.

### Developer resources

### license-tool-plugin for checking dependencies

To check if a dependency requires a CQ, the command `mvn org.eclipse.dash:license-tool-plugin:license-check -Dskip.dash=false` can be executed. This creates a summary file in `target/dash/summary`.
