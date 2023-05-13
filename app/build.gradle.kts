plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = DefaultConfig.compileSdk

    defaultConfig {
        applicationId = DefaultConfig.applicationId
        minSdk = DefaultConfig.minSdk
        targetSdk = DefaultConfig.targetSdk
        versionCode = DefaultConfig.versionCode
        versionName = DefaultConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":home:home-presentation"))
    implementation(project(":home:home-data"))
    implementation(project(":home:home-domain"))
    implementation(project(":search:search-presentation"))
    implementation(project(":detail:detail-presentation"))
    implementation(project(":common:common-utils"))

    implementation(fileTree("src/main/libs") { include("*.jar") })
    implementation(Deps.appCompat)
    implementation(Deps.core)
    implementation(Deps.constrainLayout)
    implementation(Deps.androidLegacySupport)
    testImplementation(TestImplementation.jUnit)
    androidTestImplementation(AndroidTestImplementation.jUnit)
    androidTestImplementation(AndroidTestImplementation.espresso)
    implementation(Deps.material)

    // Coroutines
    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutinesAndroid)

    // Coroutine Lifecycle Scopes
    implementation(Deps.viewModelKtx)
    implementation(Deps.lifecycleRuntime)

    // Hilt
    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)
    kapt(DaggerHilt.hiltAndroidCompiler)
}

kapt {
    correctErrorTypes = true
}
