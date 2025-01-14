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

rootProject.name = "SampleModularization"
include(":app")
include(":core")
include(":core:common")
include(":feature")
include(":feature:starwarslist")
include(":core:di")
include(":data")
include(":domain")
include(":feature:characterdetail")
include(":feature:samplefragmentxml")
include(":feature:authsupabase")
include(":feature:player")
