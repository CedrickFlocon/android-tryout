dependencyResolutionManagement {
    versionCatalogs {
        create("app") {
            version("compileSdk", "32")
            version("minSdk", "25")
        }

        create("libs") {
            version("kotlin", "1.6.10")
            alias("kotlin-gradle-plugin").to("org.jetbrains.kotlin", "kotlin-gradle-plugin").versionRef("kotlin")

            version("agp", "7.3.0")
            alias("android-gradle-plugin").to("com.android.tools.build", "gradle").versionRef("agp")
        }
    }
}
