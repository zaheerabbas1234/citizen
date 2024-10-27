pipeline {
    agent any

    environment {
        GIT_URL = 'https://github.com/zaheerabbas1234/citizen.git'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: env.GIT_URL
            }
        }

        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh './mvnw clean package'
                        sh 'echo "Building project on Unix..."'
                    } else {
                        bat 'mvn clean package'
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
                        bat 'mvn test'
                        bat 'echo Running tests on Windows...'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying the application...'
                    if (isUnix()) {
                        sh 'echo "Deploying project on Unix..."'
                        // Add Unix-specific deployment commands
                    } else {
                        bat 'echo Deploying project on Windows...'
                        // Add Windows-specific deployment commands
                    }
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
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
