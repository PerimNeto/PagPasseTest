# Etapa 1: Usar uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim as build

# Etapa 2: Copiar o arquivo .jar gerado para o contêiner
COPY target/*.jar PagPasse-0.0.1-SNAPSHOT.jar

# Etapa 3: Expor a porta que o aplicativo vai rodar (padrão 8080 no Spring Boot)
EXPOSE 8080

# Etapa 4: Definir o comando de inicialização do contêiner
ENTRYPOINT ["java", "-jar", "/PagPasse-0.0.1-SNAPSHOT.jar"]
