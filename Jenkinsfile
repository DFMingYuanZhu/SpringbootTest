pipeline {
  agent any

  stages {
    stage('build') {
      steps {
        sh 'echo build.....'
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
