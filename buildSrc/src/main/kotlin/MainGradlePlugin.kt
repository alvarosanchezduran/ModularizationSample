import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class MainGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        applyPlugins(project)
        setProjectConfig(project)
    }

    private fun applyPlugins(project: Project) {
        project.apply {
            plugin(Plugins.ANDROID_LIBRARY)
            plugin(Plugins.KOTLIN_ANDROID)
            plugin(Plugins.KOTLIN_KAPT)
            plugin("kotlin-parcelize")
        }

        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
        project.plugins.apply(libs.findPlugin("compose.compiler").get().get().pluginId)
    }

    private fun setProjectConfig(project: Project) {
        project.android().apply {
            compileSdk = AndroidConfig.COMPILE_SDK

            defaultConfig {
                minSdk = AndroidConfig.MIN_SDK
                testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }

            buildFeatures {
                buildConfig = true
                compose = true
            }
        }
    }

    private fun Project.android(): LibraryExtension {
        return extensions.getByType(LibraryExtension::class.java)
    }
}