# Use a imagem oficial do OpenJDK como base
FROM openjdk:17-oracle

# Diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY target/finunsizeapi.jar finunsizeapi.jar

COPY finunsizeapi/.env .env

# Porta que a aplicação Spring Boot está configurada para escutar
EXPOSE 8080

# Comando para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "finunsizeapi.jar"]