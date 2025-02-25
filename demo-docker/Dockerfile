# Etapa 1: Build da aplicação
FROM eclipse-temurin:21-jdk AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia todo o projeto para dentro do container
COPY . .

RUN chmod +x mvnw

# Compila o projeto usando Maven
RUN ./mvnw clean package -DskipTests

# Etapa 2: Criação da imagem final apenas com o JAR
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas o JAR gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
