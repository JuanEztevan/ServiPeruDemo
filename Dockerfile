# Usa una imagen base con Java 17 (ideal para Spring Boot)
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar desde la carpeta release (ajustado según tu estructura)
COPY release/ServiPeru-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que Render usará (Render lo reemplaza con su variable PORT)
EXPOSE 10000

# Comando para ejecutar tu aplicación
CMD ["java", "-jar", "app.jar"]
