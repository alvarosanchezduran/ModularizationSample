plugins {
    `android-library`
    `kotlin-android`
    id(Plugins.DAGGER_HILT)
    kotlin(Plugins.KAPT)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.alvaro.samplemodularization.feature.starwarslist"
}

dependencies {
    // AndroidX
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.kotlinx.collections.immutable)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.material3)
    implementation(libs.androidx.ui.tooling)

    // Core
    implementation(libs.core.ktx)
    implementation(libs.runtime)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Modules
    implementation(project(Modules.COMMON))
    implementation(project(Modules.DOMAIN))

    // Navigation
    implementation(libs.navigation.ui.ktx)
    implementation(libs.androidx.hilt.navigation.compose)
}