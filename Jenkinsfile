pipeline {
    agent any

    tools {
        maven 'Maven_3.8.1'
    }

    environment {
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
    }

    post {
        success {
            mail to: 'rafahon088@polsl.pl',
                 subject: "✔️ Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build zakończony sukcesem.\nSprawdź: ${env.BUILD_URL}"
        }
        failure {
            mail to: 'rafahon088@polsl.pl',
                 subject: "❌ Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build nie powiódł się.\nSprawdź szczegóły: ${env.BUILD_URL}"
        }
    }
}
