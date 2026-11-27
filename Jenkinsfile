
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
              sh "wget https://download.eclipse.org/ee4j/glassfish/glassfish-7.0.11.zip"
              sh "unzip glassfish-7.0.11.zip"

              sh "rm glassfish7/glassfish/modules/jakarta.mvc-api.jar"
              sh "rm glassfish7/glassfish/modules/krazo-*.jar"

              sh "glassfish7/bin/asadmin start-domain"

              sh "mvn -Psnapshots -pl tck -DversionUpdateCheckSkip -Ddash.skip -Dtck-env=glassfish verify"

              sh "glassfish7/bin/asadmin stop-domain"
            }
        }
    }
 }
}
