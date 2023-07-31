rootProject.name = "Android Tryout"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("gradle/catalog.toml"))
        }
    }
}

include(":app")
