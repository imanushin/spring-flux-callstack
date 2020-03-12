import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.config.JvmTarget

plugins {
    application
    kotlin("jvm") version embeddedKotlinVersion
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.2.5.RELEASE")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.4")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "12"
        }
    }
}

application {
    mainClassName="com.github.imanushin.spring.flux.callstack.ProblematicConfigurationKt"
}