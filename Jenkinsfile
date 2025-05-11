pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/JakubDrozd1/logowanie.git'
            }
        }

        stage('Build') {
            steps {
                bat 'gradlew.bat build'
            }
        }

        stage('Test') {
            steps {
                echo 'Brak testów – etap testów pominięty.'
            }
        }
    }
}
