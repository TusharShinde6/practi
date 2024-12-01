pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                checkout scm
            }
        }

        stage('Setup') {
            steps {
                echo 'Setting up environment...'

                // Ensure Maven is installed and configured
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    env.MAVEN_HOME = "${mvnHome}"
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling the code...'
                // Compile the code
                sh '${MAVEN_HOME}/bin/mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running TestNG tests...'
                // Run TestNG tests
                sh '${MAVEN_HOME}/bin/mvn test'
            }
        }

        stage('Publish TestNG Reports') {
            steps {
                echo 'Publishing TestNG reports...'
                // Publish TestNG reports using the HTML Publisher Plugin
                publishHTML([allowMissing: false,
                             alwaysLinkToLastBuild: true,
                             keepAll: true,
                             reportDir: 'target/surefire-reports',
                             reportFiles: 'index.html',
                             reportName: 'TestNG Results'])
            }
        }
    }

    post {
        always {
            // Clean workspace after build
            cleanWs()
        }
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
