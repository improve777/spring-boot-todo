import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
}

group = "com.improve777"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.boot:spring-boot-starter-hateoas")

    // swagger api doc
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")

    // swagger 와 hateoas 충돌 문제
    implementation("org.springframework.plugin:spring-plugin-core:1.2.0.RELEASE")

    // ORM
    implementation("org.slf4j:slf4j-api:1.7.7")
    implementation("org.hibernate:hibernate-validator:6.0.18.Final")
    implementation("javax.el:javax.el-api:3.0.0")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // 로컬 런타임 테스트용 DB
    runtimeOnly("org.hsqldb", "hsqldb", "2.3.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
