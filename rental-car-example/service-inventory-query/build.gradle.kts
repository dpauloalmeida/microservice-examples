plugins {
	id("org.springframework.boot")
	kotlin("jvm")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.apache.kafka:kafka-clients:2.3.1")
	implementation("org.axonframework:axon-spring-boot-starter:4.1.2") {
		exclude(group = "org.axonframework", module = "axon-server-connector")
	}
	implementation("org.axonframework.extensions.kafka:axon-kafka-spring-boot-starter:4.0-RC3")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.springframework.kafka:spring-kafka-test")
}
