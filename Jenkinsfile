pipeline {
  agent any
  tools {
          //set jdk version
          jdk 'jdk11'
      }

  stages {
    stage('build') {
      steps {
        sh 'echo build 123.....'
        sh 'mvn clean package'
      }
    }

      /**
       * parameters {
       choice(
       name: 'VERSION',
       choices: ['MVSURE_v1.1', 'MVSURE_v1.2', 'MVSURE_v2.2'],
       description: 'Which version do you want scan on black duck? MVSURE_v1.1, MVSURE_v1.2 or others?')
       choice(
       name: 'REPO',
       choices: ['blog-server', 'blog-client', 'blog-docker'],
       description: 'Which repository code does above VERSION belong to?')
       string(
       name: 'BRANCH',
       defaultValue: 'develop',
       description: 'Which branch does above VERSION belong to?')
       choice(
       name: 'SNIPPET-MODES',
       choices: ['SNIPPET_MATCHING', 'SNIPPET_MATCHING_ONLY', 'FULL_SNIPPET_MATCHING', 'FULL_SNIPPET_MATCHING_ONLY', 'NONE'],
       description: 'What snippet scan mode do you want to choose?')
       }

       environment {
       ROBOT                  = credentials("d1cbab74-823d-41aa-abb7-858485121212")
       hub_detect             = 'https://blackducksoftware.github.io/hub-detect/hub-detect.sh'
       blackduck_url          = 'https://yourcompany.blackducksoftware.com'
       blackduck_user         = 'robot@yourcompany.com'
       detect_project         = 'GITHUB'
       detect_project_version = '${VERSION}'
       detect_source_path     = '${WORKSPACE}/${REPO}/src'
       }

       */

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
          emailext(
                  subject: '${PROJECT_NAME} Build Success！',
                  to: 'xxx@xxx.com',
                  body: '${PROJECT_NAME} Build Success！The body for more detail')
      }
      failure {
          emailext(subject: '${PROJECT_NAME} Build Fail',
                  to: 'xxx@xxx.com',
                  body: '${PROJECT_NAME} Build Success！The body for more detail')
      }
  }
}
