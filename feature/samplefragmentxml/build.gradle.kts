plugins {
    `android-library`
    `kotlin-android`
    id(Plugins.DAGGER_HILT)
    kotlin(Plugins.KAPT)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.alvaro.samplemodularization.feature.samplefragmentxml"
}

dependencies {
    // AndroidX
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.material3)
    implementation(libs.androidx.ui.tooling)

    // Core
    implementation(libs.core.ktx)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Navigation (para navegar entre Fragments)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui.ktx)

    // Modules
    implementation(project(Modules.COMMON))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.DI))
}