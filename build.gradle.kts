buildscript {
    subprojects {
        when (type) {
            ProjectType.Application -> androidLibs.plugins.android.application
            ProjectType.Library -> androidLibs.plugins.android.library
        }.run { apply(plugin = id) }
        apply(plugin = baseLibs.plugins.kotlin.android.id)
        apply(plugin = baseLibs.plugins.kotlin.kapt.id)
        apply(plugin = baseLibs.plugins.google.firebase.crashlytics.id)
        apply(plugin = androidLibs.plugins.hilt.id)

        androidConfig {
            compileSdkVersion(33)
            defaultConfig {
                minSdk = 31
                compileSdkVersion(33)
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables { useSupportLibrary = true }
                consumerProguardFiles("consumer-rules.pro")
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }

        dependencies {
            implementation(baseLibs.bundles.core)
            implementation(androidLibs.bundles.core)
            kapt(androidLibs.android.dagger.hilt.compiler)
            implementation(androidLibs.bundles.hilt)
            implementation(platform(baseLibs.google.firebase.bom))
            implementation(baseLibs.google.firebase.analytics)
            implementation(baseLibs.google.firebase.crashlytics.asProvider())

            testImplementation(androidLibs.bundles.test.unit)
            androidTestImplementation(androidLibs.bundles.test.instrumental)
        }
    }
}
