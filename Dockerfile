# 베이스 이미지 선택 (JDK 17 사용)
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 빌드를 위한 Gradle Wrapper 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Gradle 빌드 권한 설정
RUN chmod +x gradlew

# 애플리케이션 빌드
RUN ./gradlew build -x test

# 빌드 결과물 복사 (수정된 부분)
RUN mkdir -p build/libs
RUN find build/libs -name '*.jar' -exec cp {} app.jar \; || echo "No JAR file found"

# 컨테이너 실행 시 실행할 명령어
CMD ["java", "-jar", "app.jar"]