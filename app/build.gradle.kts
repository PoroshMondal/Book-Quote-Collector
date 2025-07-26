plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.safeArgsPlugin)
}

android {
    namespace = "com.bqc.somvob.bookquotecollector"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.bqc.somvob.bookquotecollector"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
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

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.material)

    // view model
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)

    // room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)

    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // data store preference
    implementation(libs.datastore.preferences)

    // multidex
    implementation(libs.multidex)
    implementation(libs.work.rxjava2)

    // dependency injection
    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.android.compiler)
    annotationProcessor(libs.androidx.annotation)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}