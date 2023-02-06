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
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//swagger
	// https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
//	implementation("io.springfox:springfox-swagger2:2.9.2")
//    implementation("io.springfox:springfox-swagger-ui:2.9.2")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
//	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security
	implementation("org.springframework.boot:spring-boot-starter-security:2.7.5")


	//
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")


// https://mvnrepository.com/artifact/com.google.api-client/google-api-client
	implementation("com.google.api-client:google-api-client:2.0.0")

	//mysql driver
	runtimeOnly("com.mysql:mysql-connector-j")




}

tasks.withType<Test> {
	useJUnitPlatform()
}
