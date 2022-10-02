plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	java
}

group = "com.heroslender"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.19.0")
	implementation("org.apache.logging.log4j:log4j-api:2.19.0")
	implementation("org.apache.logging.log4j:log4j-core:2.19.0")
	implementation("org.slf4j:jcl-over-slf4j:2.0.3")
	implementation("org.slf4j:jul-to-slf4j:2.0.3")

	runtimeOnly("com.h2database:h2")

	implementation("org.jetbrains:annotations:23.0.0")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
