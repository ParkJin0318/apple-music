object Dependency {

    object Kotlinx {
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1"
    }

    object Core {
        private const val version = "1.9.0"

        const val core = "androidx.core:core-ktx:$version"
    }

    object Lifecycle {
        private const val version = "2.6.1"

        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    }

    object Compose {
        const val bom = "androidx.compose:compose-bom:2023.03.00"
        const val foundation = "androidx.compose.foundation:foundation"

        object UI {
            const val ui = "androidx.compose.ui:ui"
            const val graphics = "androidx.compose.ui:ui-graphics"
            const val preview = "androidx.compose.ui:ui-tooling-preview"

            const val tooling = "androidx.compose.ui:ui-tooling"
            const val manifest = "androidx.compose.ui:ui-test-manifest"
        }
    }

    object Activity {
        private const val version = "1.7.1"

        const val compose = "androidx.activity:activity-compose:$version"
    }

    object Navigation {
        private const val version = "2.6.0"

        const val compose = "androidx.navigation:navigation-compose:$version"
    }

    object Hilt {
        private const val version = "2.44.1"

        const val android = "com.google.dagger:hilt-android:$version"
        const val complier = "com.google.dagger:hilt-compiler:$version"
        const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Room {
        private const val version = "2.4.3"

        const val room = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val complier = "androidx.room:room-compiler:$version"
    }

    object Coil {
        private const val version = "2.4.0"

        val compose = "io.coil-kt:coil-compose:$version"
    }

    object Okhttp {
        private const val version = "4.11.0"

        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val serialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0"
    }

    object Kotest {
        private const val version = "5.6.2"

        const val runner = "io.kotest:kotest-runner-junit5:$version"
        const val assertions = "io.kotest:kotest-assertions-core:$version"
    }
}
