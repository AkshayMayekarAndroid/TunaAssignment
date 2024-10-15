import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.compiler)
    kotlin("plugin.serialization") version "1.9.23" // Make sure the serialization plugin is added

}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core) // Add this for content negotiation

            implementation(libs.ktor.client.core) // Check for the latest version
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.ktor.client.json)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.kotlinx.serialization.core)
        }
        androidMain.dependencies {
            // implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.androidx.activity.compose)
            implementation(libs.compose.ui) // Jetpack Compose UI
            implementation(libs.compose.material3) // Material3 components
            implementation(libs.compose.ui.tooling.preview)
            implementation(project.dependencies.platform("androidx.compose:compose-bom:2024.09.03")) // Use the Compose BOM


            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.material3)
            implementation(libs.androidx.activity.compose)
            //   implementation(libs.koin.core)
            implementation(libs.koin.android)
            //  implementation(libs.koin.androidx.viewmodel)

            implementation(libs.ktor.client.okhttp) // For Android

            implementation(libs.ktor.client.core) // Check for the latest version
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.ktor.client.json)
            implementation(libs.ktor.client.content.negotiation)
        }


        iosMain.dependencies {
            implementation(libs.ktor.client.darwin) // For iOS

        }
    }
}

android {
    namespace = "com.example.tunaassignment"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
   /* composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15" // Match this with your Compose version
    }*/


}

/*composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}*/
dependencies {
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.material3.android)
}
