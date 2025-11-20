# =========================
# 1. BUILD STAGE
# =========================
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Maven wrapper scripts (if present)
COPY mvnw .
COPY .mvn .mvn

# Copy pom.xml first for dependency caching
COPY pom.xml .

# Download dependencies (speeds up incremental builds)
RUN ./mvnw dependency:go-offline -B || true

# Now copy the actual source code
COPY src src

# Build the jar file
RUN ./mvnw clean package -DskipTests

# =========================
# 2. RUNTIME STAGE
# =========================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# EXPOSE ONLY IF YOUR SERVICE USES THAT PORT
EXPOSE 8080

# Use a non-root user (safer for cloud)
RUN useradd -m spring
USER spring

# Run the app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
