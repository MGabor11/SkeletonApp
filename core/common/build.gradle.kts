plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)
}
java {
    sourceCompatibility = JavaVersion.VERSION_23
    targetCompatibility = JavaVersion.VERSION_23
}
kotlin {
    jvmToolchain(23)
}
dependencies {
    implementation(libs.kotlinx.coroutines.core)

    // Hilt
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
}
