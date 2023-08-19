plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.parkjin.music.core.domain"
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
}

dependencies {

    implementation(Dependency.Hilt.android)
    kapt(Dependency.Hilt.complier)

    testImplementation(Dependency.Kotest.runner)
    testImplementation(Dependency.Kotest.assertions)
}
