pipeline {
    agent any

    stages {
        stage('Install Git') {
            steps {
                echo 'Checking if Git is installed...'
                // Check if Git is installed, if not, install it
                sh '''
                    if ! command -v git &> /dev/null
                    then
                        echo "Git not found, installing..."
                        sudo apt-get update -y
                        sudo apt-get install -y git
                    else
                        echo "Git is already installed"
                    fi
                '''
            }
        }

        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository with credentials
                checkout([$class: 'GitSCM', 
                          branches: [[name: '*/master']], 
                          userRemoteConfigs: [[url: 'https://github.com/TusharShinde6/practi.git',
                                               credentialsId: '7fb5bd04-f896-4585-b12e-0be0adc5e39b']]])
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
                // Compile the code using Maven
                sh '${MAVEN_HOME}/bin/mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running TestNG tests...'
                // Run TestNG tests using Maven
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
                             reportFiles: '**/*.html',
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
