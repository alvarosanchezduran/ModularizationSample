plugins {
    `android-library`
    `kotlin-android`
    id(Plugins.DAGGER_HILT)
    kotlin(Plugins.KAPT)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.alvaro.samplemodularization.core.common"
}

dependencies {
    // Core
    implementation(libs.core.ktx)
    implementation(libs.runtime)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.lifecycle.runtime.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.kotlinx.collections.immutable)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.material3)
    implementation(libs.androidx.ui.tooling)
}