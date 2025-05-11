pipeline {
    agent any

    tools {
        maven 'Maven_3.8.1'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/JakubDrozd1/logowanie.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
