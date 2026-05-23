
pipeline {
  agent any

  tools {
    maven "apache-maven-latest"
    jdk "temurin-latest"
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
              sh "wget https://download.eclipse.org/ee4j/glassfish/glassfish-780.2.zip"
              sh "unzip glassfish-8.0.2.zip"

              sh "rm glassfish7/glassfish/modules/jakarta.mvc-api.jar"
              sh "rm glassfish7/glassfish/modules/krazo-*.jar"

              sh "glassfish8/bin/asadmin start-domain"

              sh "mvn -Pstaging,testsuite-glassfish verify"

              sh "glassfish8/bin/asadmin stop-domain"
            }
        }
    }
 }
}
