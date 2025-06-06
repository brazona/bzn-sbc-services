# Etapa 1: Compilar a aplicação
FROM maven:3.9.9-sapmachine-24 AS build

LABEL maintainer=Brazona\ Cézar
VOLUME /tmp

ARG ARG_SPRING_ACTIVE_PROFILE
ARG ARG_APPLICATION_NAME
ARG ARG_CONFIG_SERVER_PASS
ARG ARG_CONFIG_SERVER_USER
ARG ARG_CONFIG_SERVER_HOST
ARG ARG_APP_SERVER_PORT_INT
ARG ARG_APP_SERVER_PORT_EXT

ENV SPRING_ACTIVE_PROFILE=$ARG_SPRING_ACTIVE_PROFILE
ENV APPLICATION_NAME=$ARG_APPLICATION_NAME
ENV CONFIG_SERVER_PASS=$ARG_CONFIG_SERVER_PASS
ENV CONFIG_SERVER_USER=$ARG_CONFIG_SERVER_USER
ENV CONFIG_SERVER_HOST=$ARG_CONFIG_SERVER_HOST
ENV APP_SERVER_PORT_INT=$ARG_APP_SERVER_PORT_INT
ENV APP_SERVER_PORT_EXT=$ARG_APP_SERVER_PORT_EXT


# Define o diretório de trabalho dentro do contêiner
WORKDIR /app
# Copia o arquivo pom.xml e os arquivos de dependências para o diretório de trabalho
COPY pom.xml ./
COPY src ./src

# Compila a aplicação
RUN mvn clean install

# Etapa 2: Criar a imagem final para execução
FROM openjdk:24-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Cria um argumento para o nome da aplicação
ARG JAR_FILE=target/*.jar

# Copia o jar compilado da etapa anterior
COPY --from=build /app/${JAR_FILE} app.jar

# Expõe a porta da aplicação
EXPOSE $APP_SERVER_PORT_EXT

# Define o comando padrão para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
