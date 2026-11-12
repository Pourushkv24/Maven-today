
# Use Maven with Java 17
FROM maven:3.9.9-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy Maven configuration
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Run JUnit tests
CMD ["mvn", "clean", "test"]
