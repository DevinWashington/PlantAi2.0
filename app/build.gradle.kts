plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}


android {
    namespace = "com.example.plantai2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.plantai2"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        //noinspection DataBindingWithoutKapt
        viewBinding=true

    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.support.annotations)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1") // If using Java

    // ViewModel and LiveData (for managing UI-related data)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0") // If using Kotlin
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")   // If using Kotlin
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.0")     // If using Java
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.0")       // If using Java

    // Navigation Component (for managing fragment transitions)
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7") // If using Kotlin
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")       // If using Kotlin
    implementation("androidx.navigation:navigation-fragment:2.7.7")     // If using Java
    implementation("androidx.navigation:navigation-ui:2.7.7")           // If using Java

    // Material Design Components
    implementation("com.google.android.material:material:1.11.0")

}