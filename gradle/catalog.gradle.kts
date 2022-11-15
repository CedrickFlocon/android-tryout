dependencyResolutionManagement {
    versionCatalogs {
        create("app") {
            version("compile-sdk", "33")
            version("min-sdk", "25")
        }

        create("libs") {
            version("kotlin", "1.7.20")
            alias("kotlin-gradle-plugin").to("org.jetbrains.kotlin", "kotlin-gradle-plugin").versionRef("kotlin")

            version("agp", "7.3.0")
            alias("android-gradle-plugin").to("com.android.tools.build", "gradle").versionRef("agp")

            version("compose-compiler", "1.3.2")

            version("compose-bom", "2022.10.00")
            alias("compose-bom").to("androidx.compose", "compose-bom").versionRef("compose-bom")
            alias("compose-foundation").to("androidx.compose.foundation", "foundation").version("")

            version("compose-activity", "1.5.1")
            alias("compose-activity").to("androidx.activity", "activity-compose").versionRef("compose-activity")
        }
    }
}
