buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.gradle)
        classpath(libs.runtime)
        classpath(libs.hilt.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.compose.compiler) apply false
}