rootProject.name = "Android Tryout"

apply {
    from("gradle/catalog.gradle.kts")
}

include(":app")
