# Usa una imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo .jar generado por Maven
COPY target/ServiPeru-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto (Render usará la variable de entorno PORT)
EXPOSE 10000

# Ejecuta el archivo .jar
CMD ["java", "-jar", "app.jar"]
