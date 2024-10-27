pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'javac -d out src/**/*.java'  // Adjust the build command as needed
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'java -cp out org.junit.runner.JUnitCore <TestClassName>' // Replace <TestClassName> with the actual test class
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
                bat 'xcopy /E /I out \\path\\to\\deployment\\directory' // Replace with your deployment path
            }
        }
    }
}
