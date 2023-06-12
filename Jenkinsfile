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

    /* stage('Veracode Pipeline Scan') {
          steps {
            sh 'curl -O https://downloads.veracode.com/securityscan/pipeline-scan-LATEST.zip'
            sh 'unzip pipeline-scan-LATEST.zip pipeline-scan.jar'
            sh 'java -jar pipeline-scan.jar \
              --veracode_api_id "${VERACODE_API_ID}" \
              --veracode_api_key "${VERACODE_API_SECRET}" \
              --file "build/libs/sample.jar" \
              --fail_on_severity="Very High, High" \
              --fail_on_cwe="80" \
              --baseline_file "${CI_BASELINE_PATH}" \
              --timeout "${CI_TIMEOUT}" \
              --project_name "${env.JOB_NAME}" \
              --project_url "${env.GIT_URL}" \
              --project_ref "${env.GIT_COMMIT}"'
          }
        }
 */

      /*
      stage("black duck scan") {
      //Black Duck arguments
         steps {
             withCredentials([string(credentialsId: 'robot-black-duck-scan', variable: 'TOKEN')]) {
                 //get Token by withCredentials
                 synopsys_detect 'bash <(curl -s ${hub_detect}) \
                         --blackduck.url=${blackduck_url} \
                         --blackduck.username=${blackduck_user} \
                         --blackduck.api.token=${TOKEN} \
                         --detect.project.name=${detect_project} \
                         --detect.project.version.name=${detect_project_version} \
                         --detect.source.path=${detect_source_path} \
                         --logging.level.com.synopsys.integration=debug \
                         --blackduck.trust.cert=TRUE \
                         --detect.blackduck.signature.scanner.snippet.matching=${SNIPPET-MODES}'
             }
         }
      }
       */
      /*
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
    }*/
  }

  post {


      success {
          emailext (
                  subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                  body: """<p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
                  to: "zhumingyuan91@163.com",
                  from: "mingyuanzhu20@gmail.com"
          )
      }
      failure {
          emailext (
                  subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                  body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
                  to: "zhumingyuan91@163.com",
                  from: "mingyuanzhu20@gmail.com"
          )
      }
  }
}
