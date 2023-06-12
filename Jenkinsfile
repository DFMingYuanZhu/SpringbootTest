pipeline {
  agent any
  tools {
          // 指定JDK版本
          jdk 'jdk11'
      }

  stages {
    stage('build') {
      steps {
        sh 'echo build 123.....'
        sh 'echo build 456.....'
      }
    }

    stage ('Sonarqube') {
        environment {
                scannerHome = tool 'SonarQubeScanner'
            }
            steps {
              withEnv(['JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/', 'PATH+JAVA=$JAVA_HOME/bin']) {
                withSonarQubeEnv('SonarQube') {
                                    sh "${scannerHome}/bin/sonar-scanner"
                                }
                                timeout(time: 10, unit: 'MINUTES') {
                                    waitForQualityGate abortPipeline: true
                                }
              }
           }
    }
  }

  post {
    success {
      echo 'build success!'
    }

    failure {
      echo 'build failed!'
    }
  }
}
