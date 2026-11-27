
pipeline {
  agent any

  tools {
    maven "apache-maven-latest"
    jdk "temurin-jdk21-latest"
  }

  stages {
    stage("Compile") {
      steps {
        withMaven() {
          sh "mvn -Psnapshots compile"
        }
      }
    }

    stage("Unit Tests & install") {
      steps {
        withMaven() {
          sh "mvn -Psnapshots install"
        }
      }
    }

    stage("Integration-Test") {
        steps {
            withMaven() {
              sh "wget https://github.com/eclipse-ee4j/glassfish/releases/download/9.0.0-M4/glassfish-9.0.0-M4.zip"
              sh "unzip glassfish-9.0.0-M4.zip"

              sh "rm glassfish9/glassfish/modules/jakarta.mvc-api.jar"
              sh "rm glassfish9/glassfish/modules/krazo-*.jar"

              sh "glassfish9/bin/asadmin start-domain"

              sh "mvn -Psnapshots -pl tck -DversionUpdateCheckSkip -Ddash.skip -Dtck-env=glassfish verify"

              sh "glassfish9/bin/asadmin stop-domain"
            }
        }
    }
 }
}
