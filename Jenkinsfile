pipeline {
    agent any

    environment {
        GIT_URL = 'https://github.com/zaheerabbas1234/citizen.git'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/zaheerabbas1234/citizen.git'
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: env.GIT_URL]]])
                }
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package'
                script {
                    if (isUnix()) {
                        sh 'echo "Building project on Unix..."'
                        // Place Unix-specific build commands here (e.g., sh './build.sh')
                    } else {
                        bat 'echo Building project on Windows...'
                        // Place Windows-specific build commands here (e.g., bat 'build.bat')
                    }
                }
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
                script {
                    if (isUnix()) {
                        sh 'echo "Running tests on Unix..."'
                        // Place Unix-specific test commands here (e.g., sh './test.sh')
                    } else {
                        bat 'echo Running tests on Windows...'
                        // Place Windows-specific test commands here (e.g., bat 'test.bat')
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Add custom deployment steps here
                script {
                    if (isUnix()) {
                        sh 'echo "Deploying project on Unix..."'
                        // Place Unix-specific deployment commands here
                    } else {
                        bat 'echo Deploying project on Windows...'
                        // Place Windows-specific deployment commands here
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
