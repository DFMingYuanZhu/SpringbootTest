pipeline {
  agent any

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
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
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
