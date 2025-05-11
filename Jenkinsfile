pipeline {
    agent any

    tools {
        maven 'Maven_3.8.1'
    }

    environment {
        // Token do SonarQube przypisany w Jenkins → Credentials
        SONAR_TOKEN = credentials('sonarqube')
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/RafHon/logowanie.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonar') {
                    bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=logowanie ^
                        -Dsonar.host.url=%SONAR_HOST_URL% ^
                        -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
