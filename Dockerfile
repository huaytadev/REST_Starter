# ============================
# Etapa 1 - Build
# ============================

# Imagen con Maven y Java 21 para compilar el proyecto
FROM maven:3.9.11-eclipse-temurin-21 AS builder

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos primero el pom para aprovechar la caché de Docker
COPY pom.xml .

# Descargamos todas las dependencias
RUN mvn dependency:go-offline

# Copiamos la carpeta .mvn, los scripts del wrapper y el resto del proyecto
COPY .mvn ./.mvn
COPY mvnw ./
COPY mvnw.cmd ./
COPY src ./src

# Compilamos el proyecto sin ejecutar tests
RUN mvn clean package -DskipTests

# ============================
# Etapa 2 - Runtime
# ============================

# Imagen mucho más liviana únicamente con Java 21
FROM eclipse-temurin:21-jre

# Directorio donde vivirá la aplicación
WORKDIR /app

# Copiamos únicamente el jar generado
COPY --from=builder /app/target/*.jar app.jar

# Puerto que utilizará Spring Boot
EXPOSE 8080

# Comando que inicia la aplicación
ENTRYPOINT ["java","-jar","app.jar"]