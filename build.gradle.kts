plugins {
    kotlin("js") version "1.5.10"
}

repositories {
    mavenLocal()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    maven("https://s01.oss.sonatype.org/content/repositories/releases/")
    mavenCentral()
}

kotlin {
    js(IR) {
        browser()
    }.binaries.executable()

    sourceSets {
        val main by getting {
            dependencies {
                implementation("dev.fritz2:components:0.12-SNAPSHOT")
            }
        }
    }
}