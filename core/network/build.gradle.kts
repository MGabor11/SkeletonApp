plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}
java {
    sourceCompatibility = JavaVersion.VERSION_23
    targetCompatibility = JavaVersion.VERSION_23
}
kotlin {
    jvmToolchain(23)
}
dependencies {
    implementation(project(path = ":core:domain"))
    implementation(project(path = ":core:common"))

    // Hilt
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)

    // Retrofit
    implementation(libs.retrofit)

    // The official Kotlinx Serialization Converter
    implementation(libs.retrofit.kotlinx.serialization.converter )

    // Kotlinx Serialization JSON library
    implementation(libs.kotlinx.serialization.json)

    // OkHttp (required for MediaType)
    implementation(libs.okhttp)
}
