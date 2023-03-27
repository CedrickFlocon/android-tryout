dependencyResolutionManagement {
    versionCatalogs {
        create("app") {
            version("compile-sdk", "33")
            version("min-sdk", "25")
        }

        create("libs") {
            version("kotlin", "1.8.10")
            library("kotlin-gradle-plugin", "org.jetbrains.kotlin", "kotlin-gradle-plugin").versionRef("kotlin")

            version("agp", "7.4.2")
            library("android-gradle-plugin", "com.android.tools.build", "gradle").versionRef("agp")

            version("compose-compiler", "1.4.4")

            version("compose-bom", "2023.03.00")
            library("compose-bom", "androidx.compose", "compose-bom").versionRef("compose-bom")
            library("compose-foundation", "androidx.compose.foundation", "foundation").version("")

            version("compose-activity", "1.5.1")
            library("compose-activity", "androidx.activity", "activity-compose").versionRef("compose-activity")
        }
    }
}
