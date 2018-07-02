import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.2.50"
	id("org.jetbrains.kotlin.plugin.spring") version "1.2.50"
	id("org.springframework.boot") version "2.0.3.RELEASE"
	id("io.spring.dependency-management") version "1.0.5.RELEASE"
}

group = "io.github.alexbogovich"
version = "0.0.1-SNAPSHOT"

configure<JavaPluginConvention> {
	setSourceCompatibility(1.8)
	setTargetCompatibility(1.8)
}


val compileKotlin by tasks.getting(KotlinCompile::class) {
	kotlinOptions.jvmTarget = "1.8"
	kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
}

repositories {
	mavenCentral()
}


dependencies {
	compile ("javax.xml.bind:jaxb-api:2.3.0")

	compile("org.springframework.boot:spring-boot-starter-aop")
	compile("org.springframework.boot:spring-boot-starter-cache")
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("org.springframework.boot:spring-boot-starter-data-rest")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin")
	compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	runtime("org.springframework.boot:spring-boot-devtools")
	runtime("com.h2database:h2")
	testCompile("org.springframework.boot:spring-boot-starter-test")
}
