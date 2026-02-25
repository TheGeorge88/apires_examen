# ---------- ETAPA 1: BUILD ----------
FROM maven:3.8.8-openjdk-17 AS compilacion

WORKDIR /proyecto

# Copiar todo el proyecto
COPY . .

# Compilar sin tests
RUN mvn clean package -DskipTests


# ---------- ETAPA 2: SERVIDOR ----------
FROM openjdk:17-jdk-slim

WORKDIR /deploy

# Copiar el archivo generado
COPY --from=compilacion /proyecto/target/*.jar vacaciones-app.jar

# Crear carpeta logs
RUN mkdir logs

# Puerto diferente
EXPOSE 9090

# Configuración zona horaria
ENV TZ=America/Guayaquil

# Comando de ejecución con perfil activo
CMD ["java", "-jar", "vacaciones-app.jar", "--spring.profiles.active=prod"]
