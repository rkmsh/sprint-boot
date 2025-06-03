# ---------- STAGE 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set work directory inside container
WORKDIR /app
    
# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline
    
# Copy entire source code
COPY src ./src
    
# Package the application
RUN mvn clean package -DskipTests
    
# ---------- STAGE 2: Run ----------
FROM eclipse-temurin:21-jdk
    
WORKDIR /app
    
# Copy the JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar
    
# Expose port (optional, based on your app)
EXPOSE 8080
    
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
    