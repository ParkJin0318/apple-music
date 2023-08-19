plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.parkjin.music.core.design"
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

    implementation(Dependency.Core.core)
    implementation(platform(Dependency.Compose.bom))
    implementation(Dependency.Compose.UI.ui)
    implementation(Dependency.Compose.UI.graphics)
    implementation(Dependency.Compose.UI.preview)
    implementation(Dependency.Compose.foundation)

    debugImplementation(Dependency.Compose.UI.tooling)
    debugImplementation(Dependency.Compose.UI.manifest)

    testImplementation(Dependency.Kotest.runner)
    testImplementation(Dependency.Kotest.assertions)
}
