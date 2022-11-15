plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = app.versions.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = app.versions.min.sdk.get().toInt()
        versionName = "1.0.0"
        versionCode = 1
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.activity)
}
