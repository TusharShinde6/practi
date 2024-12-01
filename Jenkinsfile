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
                echo 'Cloning repository...'
                // Checkout the code from the Git repository with credentials
                checkout([$class: 'GitSCM', 
                          branches: [[name: '*/master']], 
                          userRemoteConfigs: [[url: 'https://github.com/TusharShinde6/practi.git',
                                               credentialsId: 'b7a92506-b84b-436e-a7b0-ec2a9f76a7ec']]])
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                script {
                    // Build the Docker image using the Dockerfile
                    docker.build('selenium-test')
                }
            }
        }

        stage('Run Tests in Docker') {
            steps {
                echo 'Running tests inside Docker container...'
                script {
                    // Run the Docker container and execute Maven commands
                    sh '''
                    docker run --rm \
                        -v "$PWD:/workspace" \   # Mount the current workspace
                        -w /workspace \          # Set working directory in the container
                        selenium-test \
                        /bin/bash -c "
                            mvn clean compile &&
                            mvn test
                        "
                    '''
                }
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
