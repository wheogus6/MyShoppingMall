plugins {
	java
	id("org.springframework.boot") version "2.7.7"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.wheogus"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	//롬복 추가
	implementation("org.projectlombok:lombok:1.18.22")


	// https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf
	implementation("org.thymeleaf:thymeleaf:3.0.11.RELEASE")
	// https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity5
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")

	// https://mvnrepository.com/artifact/com.mashape.unirest/unirest-java
	implementation("com.mashape.unirest:unirest-java:1.4.9")

	//swagger
	// https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
	implementation("io.springfox:springfox-boot-starter:3.0.0")

	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security
	implementation("org.springframework.boot:spring-boot-starter-security:2.7.5")

	// https://mvnrepository.com/artifact/org.springframework.security.oauth/spring-security-oauth2
	implementation("org.springframework.security.oauth:spring-security-oauth2:2.3.4.RELEASE")

//	//oauth
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//	// https://mvnrepository.com/artifact/com.google.api-client/google-api-client
//	implementation("com.google.api-client:google-api-client:2.0.0")

	// https://mvnrepository.com/artifact/com.konghq/unirest-java
	implementation("com.konghq:unirest-java:3.13.6")

	// https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
	implementation("com.mysql:mysql-connector-j")

	// https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
	implementation("org.apache.commons:commons-lang3:3.12.0")

	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")

	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")






}

tasks.withType<Test> {
	useJUnitPlatform()
}
