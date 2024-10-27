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
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
                    userRemoteConfigs: [[url: env.GIT_URL]]])
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh './mvnw clean package'
                        sh 'echo "Building project on Unix..."'
                    } else {
                        bat './mvnw.cmd clean package'
                        bat 'echo Building project on Windows...'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh './mvnw test'
                        sh 'echo "Running tests on Unix..."'
                    } else {
                        bat './mvnw.cmd test'
                        bat 'echo Running tests on Windows...'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                script {
                    if (isUnix()) {
                        sh 'echo "Deploying project on Unix..."'
                        // Add Unix deployment commands if needed
                    } else {
                        bat 'echo Deploying project on Windows...'
                        // Add Windows deployment commands if needed
                    }
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            echo 'Archiving artifacts...'
        }
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
            archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
        }
    }
}
