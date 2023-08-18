object Dependency {

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
            const val graphic = "androidx.compose.ui:ui-graphic"
            const val tooling = "androidx.compose.ui:ui-tooling-preview"
        }
    }

    object Activity {
        private const val version = "1.7.1"

        const val compose = "androidx.activity:activity-compose:$version"
    }

    object Kotest {
        private const val version = "5.6.2"

        const val runner = "io.kotest:kotest-runner-junit5:$version"
        const val assertions = "io.kotest:kotest-assertions-core:$version"
    }
}
