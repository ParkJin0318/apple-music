plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.parkjin.music.core.design"
    compileSdk = 33

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependency.Core.core)
    implementation(Dependency.Lifecycle.runtime)
    implementation(Dependency.Activity.compose)
    implementation(platform(Dependency.Compose.bom))
    implementation(Dependency.Compose.UI.ui)
    implementation(Dependency.Compose.UI.tooling)
    implementation(Dependency.Compose.foundation)

    testImplementation(Dependency.Kotest.runner)
    testImplementation(Dependency.Kotest.assertions)
}
