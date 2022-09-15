pipeline {
  agent any
  tools {
    jdk 'jdk11'
    maven 'maven386'
  }
  stages {
    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Package') {
      parallel {
        stage('Package') {
          steps {
            sh 'mvn package'
          }
        }

        stage('Publish Result') {
          steps {
            junit 'target/**/*.xml'
          }
        }

      }
    }

    stage('Archive Artifact') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }

  }
}
