# Pipeline



pipeline {
    agent any

    tools {
        maven "apache-maven"
    }

    stages {
        stage('Responsável pela aprovação') {
            steps {
                script {
                    timeout(time: 2, unit: "HOURS") {
                    def userInput = input(
                    id: 'userInput', message: 'Deploy aprovado ?', parameters: [
                    [$class: 'TextParameterDefinition', defaultValue: 'Não', description: 'Realizar Deploy ?', name: 'Executar'] ] )
                    echo (userInput)
                    }
                }
            }
        }
        stage('Build') {
            steps {
                git 'https://github.com/larissahsantossilva/Sprint.git/'
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post {
                success {
                    deploy adapters: [tomcat8(credentialsId: '6cf09ad5-4977-4c7d-b7ec-4437c95bb816',
                    path: '', url: 'http://localhost:8080')], contextPath: 'smartinventory', war: '**/*.war'
                }
            }
        }
    }
}
