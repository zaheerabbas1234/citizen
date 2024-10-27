pipeline {
    agent any

    environment {
        GIT_URL = 'https://github.com/zaheerabbas1234/citizen.git'
    }

    tools {
        maven 'Maven' // Ensure Maven is available in Jenkins and configured under Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the specified Git repository
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: env.GIT_URL]]])
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo 'Building the project...'
                    // Use Maven wrapper to build the project
                    if (isUnix()) {
                        sh './mvnw clean package'
                    } else {
                        bat './mvnw.cmd clean package'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo 'Running tests...'
                    // Use Maven wrapper to run tests
                    if (isUnix()) {
                        sh './mvnw test'
                    } else {
                        bat './mvnw.cmd test'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                script {
                    // Add your deployment steps here (e.g., copy to server, deploy to cloud, etc.)
                    if (isUnix()) {
                        sh 'echo "Deploying project on Unix..."'
                        // Place Unix-specific deployment commands here if needed
                    } else {
                        bat 'echo Deploying project on Windows...'
                        // Place Windows-specific deployment commands here if needed
                    }
                }
            }
        }
    }

    post {
        always {
            // Archive the JAR file produced by the build
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            echo 'Archiving artifacts...'
        }
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
            // Archive any log files in case of failure
            archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
        }
    }
}
