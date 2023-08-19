plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.parkjin.music.feature.listening"
    compileSdk = Version.compileSdk

    defaultConfig {
        minSdk = Version.minSdk
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
}

dependencies {

    implementation(project(":core:design"))
    implementation(project(":core:domain"))

    implementation(Dependency.Core.core)
    implementation(Dependency.Lifecycle.runtime)
    implementation(platform(Dependency.Compose.bom))
    implementation(Dependency.Compose.UI.ui)
    implementation(Dependency.Compose.UI.graphics)
    implementation(Dependency.Compose.UI.preview)
    implementation(Dependency.Compose.foundation)

    debugImplementation(Dependency.Compose.UI.tooling)
    debugImplementation(Dependency.Compose.UI.manifest)

    implementation(Dependency.Hilt.android)
    implementation(Dependency.Hilt.compose)
    kapt(Dependency.Hilt.complier)

    testImplementation(Dependency.Kotest.runner)
    testImplementation(Dependency.Kotest.assertions)
}
