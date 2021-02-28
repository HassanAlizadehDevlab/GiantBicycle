import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * All dependencies for project are declared here.
 * */
object Dependencies {

    // Kotlin
    private val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // Android
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    private val lifecycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    private val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    // Android UI
    private val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val material = "com.google.android.material:material:${Versions.material}"

    // Threading
    private val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    private val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    private val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    // DI
    private val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    private val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    private val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    private val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    private val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    // Test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val mockk = "io.mockk:mockk:${Versions.mockk}"
    private val arch = "androidx.arch.core:core-testing:${Versions.arch}"


    val kotlinBundle = arrayListOf<String>().apply {
        add(kotlinStdLib)
    }

    val androidBundle = arrayListOf<String>().apply {
        add(fragment)
        add(coreKtx)
        add(appcompat)
        add(material)
        add(constraintLayout)
    }

    val lifecycleBundle = arrayListOf<String>().apply {
        add(lifecycleViewModel)
        add(lifecycleRunTime)
        add(lifecycleLiveData)
    }

    val rxBundle = arrayListOf<String>().apply {
        add(rxJava)
        add(rxKotlin)
        add(rxAndroid)
    }

    val daggerBundle = arrayListOf<String>().apply {
        add(dagger)
        add(daggerAndroid)
        add(daggerSupport)
    }

    val daggerKapt = arrayListOf<String>().apply {
        add(daggerProcessor)
        add(daggerCompiler)
    }


    // Test Libraries
    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(mockk)
        addAll(rxBundle)
        add(arch)
        add(lifecycleLiveData)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }
}


// Util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}