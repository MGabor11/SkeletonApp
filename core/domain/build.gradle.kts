plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_23
    targetCompatibility = JavaVersion.VERSION_23
}
kotlin {
    jvmToolchain(23)
}
dependencies {
    implementation(project(path = ":core:common"))

    implementation(libs.kotlinx.coroutines.core)
}
