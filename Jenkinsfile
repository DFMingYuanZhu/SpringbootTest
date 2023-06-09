pipeline {
  agent any

  stages {
    stage('build') {
      echo 'build.....'
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
