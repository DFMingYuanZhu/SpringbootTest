pipeline {
  agent any

  stages {
    stage('build') {
      steps {
        sh 'echo build 123.....'
        sh 'echo build 456.....'
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
