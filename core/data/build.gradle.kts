plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.parkjin.music.core.data"
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

    implementation(Dependency.Kotlinx.serialization)
    implementation(Dependency.Core.core)
    implementation(Dependency.Okhttp.okhttp)
    implementation(Dependency.Retrofit.retrofit)
    implementation(Dependency.Retrofit.serialization)

    implementation(Dependency.Hilt.android)
    kapt(Dependency.Hilt.complier)

    testImplementation(Dependency.Kotest.runner)
    testImplementation(Dependency.Kotest.assertions)
}
