# Usa una imagen base con Java 17 (ideal para Spring Boot)
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar desde la carpeta release (ajusta según tu estructura)
COPY release/ServiPeru-0.0.1-SNAPSHOT.jar app.jar

# Render define automáticamente la variable de entorno PORT
# No importa qué número pongas aquí, es solo informativo
EXPOSE 8080

# Comando para ejecutar la aplicación, Render asignará PORT automáticamente
CMD ["java", "-jar", "app.jar"]

