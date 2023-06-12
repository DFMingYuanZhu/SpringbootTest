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
        sh 'mvn clean package'
      }
    }

    stage('Veracode Pipeline Scan') {
          steps {
            sh 'curl -O https://downloads.veracode.com/securityscan/pipeline-scan-LATEST.zip'
            sh 'unzip -o pipeline-scan-LATEST.zip pipeline-scan.jar'
            sh 'java -jar pipeline-scan.jar \
              --veracode_api_id "${VERACODE_API_ID}" \
              --veracode_api_key "${VERACODE_API_SECRET}" \
              --file "target/SpringbootTest-1.1.jar" \
              --fail_on_severity="Very High, High" \
              --fail_on_cwe="80" \
              --timeout "60" \
              --project_name "fc-adm-ci"'
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
