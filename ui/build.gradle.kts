android {
    namespace = "com.splanes.apps.dutyfruty.ui"
    compileSdk = 33
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {
    implementation(projects.domain)

    implementation(androidLibs.android.lifecycle)
    implementation(androidLibs.bundles.compose)
    implementation(androidLibs.android.compose.lottie)
    implementation(androidLibs.android.compose.navigation)
    implementation(androidLibs.android.accompanist.navigation.anim)
    implementation(androidLibs.android.accompanist.systemuicontroller)
    implementation(androidLibs.android.accompanist.pager)
    implementation(androidLibs.android.accompanist.pager.indicators)

    testImplementation(androidLibs.bundles.test.unit)
    androidTestImplementation(androidLibs.bundles.test.instrumental)
    androidTestImplementation(androidLibs.compose.instrumental)

    debugImplementation(androidLibs.bundles.test.compose.debug)
}
