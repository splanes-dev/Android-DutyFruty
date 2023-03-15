buildscript {
    apply(plugin = baseLibs.plugins.kotlin.parcelize.id)
}

android {
    namespace = "com.splanes.apps.dutyfruty.domain"
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}
