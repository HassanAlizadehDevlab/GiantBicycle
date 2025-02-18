plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AppConfig.applicationName

        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName(AppConfig.release) {
            isMinifyEnabled = true
            proguardFile(AppConfig.proguardConsumerRules)
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        kotlinOptions {
            jvmTarget = AppConfig.javaVersion
        }
    }
}


dependencies {
    kapt(Dependencies.daggerKapt)

    // App libs
    implementation(arrayListOf<String>().apply {
        addAll(Dependencies.kotlinBundle)
        addAll(Dependencies.androidBundle)
        addAll(Dependencies.lifecycleBundle)
        addAll(Dependencies.rxBundle)
        addAll(Dependencies.daggerBundle)
    })

    // Test libs
    testImplementation(Dependencies.testLibraries)
}