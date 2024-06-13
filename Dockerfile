# Usar uma imagem base com JDK
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR para o contêiner
COPY target/ms-email-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação usa
EXPOSE 8080

# Definir o comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
