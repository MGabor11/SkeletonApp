import io.gitlab.arturbosch.detekt.Detekt

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.jetbrains.kotlin.serialization) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    // Configure the detekt plugin
    detekt {
        toolVersion = "1.23.8"

        // Set the detekt configuration from previous steps
        config.setFrom(file("$rootDir/config/detekt/detekt.yml"))

        // Build upon the default detekt configuration, instead of replacing it
        buildUponDefaultConfig = true

        // Do not activate all detekt rules
        allRules = false

        // Enable automatic correction of issues found by detekt
        autoCorrect = false

        // Run detekt in parallel mode for better performance
        parallel = true
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = "22"
    }
}
