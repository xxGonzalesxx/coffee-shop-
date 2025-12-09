# Первый этап: сборка
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Второй этап: запуск
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Создаем пользователя для безопасности
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Копируем JAR
COPY --from=builder /app/target/*.jar app.jar

# Настройки
EXPOSE 8080

# Запуск
ENTRYPOINT ["java", "-jar", "app.jar"]
