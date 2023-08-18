plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.parkjin.music"
    compileSdk = Version.compileSdk

    defaultConfig {
        applicationId = "com.parkjin.music"
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        versionCode = Version.versionCode
        versionName = Version.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":core:design"))

    implementation(Dependency.Core.core)
    implementation(Dependency.Lifecycle.runtime)
    implementation(Dependency.Activity.compose)
    implementation(platform(Dependency.Compose.bom))
    implementation(Dependency.Compose.UI.ui)
    implementation(Dependency.Compose.UI.graphics)
    implementation(Dependency.Compose.UI.preview)
    implementation(Dependency.Compose.foundation)
    implementation(Dependency.Navigation.compose)

    debugImplementation(Dependency.Compose.UI.tooling)
    debugImplementation(Dependency.Compose.UI.manifest)

    testImplementation(Dependency.Kotest.runner)
    testImplementation(Dependency.Kotest.assertions)
}
