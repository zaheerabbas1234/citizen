pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Ensure Git is installed on your Jenkins node
                echo 'Building...'
                sh 'javac -d out src/**/*.java'  // Change this command based on your project's build steps
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your testing commands here
                // For example, if using JUnit:
                sh 'java -cp out org.junit.runner.JUnitCore <TestClassName>' // Replace <TestClassName> with the actual test class
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add deployment steps here
                // Example: Copy files to a deployment directory, or trigger a deploy script
                sh 'cp -r out /path/to/deployment/directory' // Update with your actual deployment path
            }
        }
    }
}
