pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SkeletonApp"
include(":app")

include(":core:data")
include(":core:datastore")
include(":core:domain")
include(":core:network")
include(":core:navigation")
include(":core:common")
include(":core:ui")
include(":core:configuration")

include(":feature:home")
include(":feature:welcome")
