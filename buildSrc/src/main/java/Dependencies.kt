import kotlin.reflect.full.memberProperties

object Dependencies {
    const val runnerPackage = "androidx.test.runner.AndroidJUnitRunner"


    object Module {
        const val commons_network = ":commons-network"
        const val commons_ui = ":commons-ui"
    }

    val modules: List<String> by lazy {
        Module::class.memberProperties.map {
            it.name.replace("_", "-")
        }
    }

    object Gradle {
        const val kotlinPlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
        const val androidTools = "com.android.tools.build:gradle:${Versions.gradle_plugin_version}"
        const val gradlePlugin = "gradle-plugin"
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin_version}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.androidx_core_ktx}"
    }

    object UnitTest {
        const val core = "androidx.test:core:${Versions.test_core_version}"
        const val junit = "junit:junit:${Versions.test_junit_version}"
        const val runner = "androidx.test:runner:${Versions.test_core_version}"
        const val viewModelTest = "androidx.arch.core:core-testing:${Versions.viewmodel_version}"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
    }

    object AndroidTest {
        const val runner = "androidx.test:runner:${Versions.test_core_version}"
        const val espresso =
            "androidx.test.espresso:espresso-core:${Versions.test_espresso_version}"
        const val rules = "androidx.test:rules:${Versions.test_rules_version}"
        const val hamcrest = "org.hamcrest:hamcrest-library:${Versions.test_hamcrest}"
        const val uiautomator = "androidx.test.uiautomator:uiautomator:${Versions.test_uiautomator}"
        const val ext = "androidx.test.ext:junit:${Versions.test_ext}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
        const val intent =
            "androidx.test.espresso:espresso-intents:${Versions.test_espresso_version}"
    }

    object Support {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.support_version}"
        const val androidXCore = "androidx.core:core-ktx:${Versions.support_version}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraint_motion_version}"
        const val material = "com.google.android.material:material:${Versions.material_version}"
        const val animation =
            "androidx.dynamicanimation:dynamicanimation:${Versions.dynamic_animation}"
    }

    object Koin {
        const val koin = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi_version}"
        const val moshiConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_version}"
        const val coreOkhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
        const val interceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"
    }

    object ViewModel {
        const val lifecycleExtensions =
            "androidx.lifecycle:lifecycle-extensions:${Versions.viewmodel_version}"
        const val lifecycleConvertRxToLivedata =
            "androidx.lifecycle:lifecycle-reactivestreams:${Versions.viewmodel_version}"
    }

    object Compose {
        const val composeBomVersion = "androidx.compose:compose-bom:${Versions.composeBomVersion}"
        const val composeUI = "androidx.compose.ui:ui"
        const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeActivityCompose =
            "androidx.activity:activity-compose:${Versions.composeActivity}"
        const val composeUITooling = "androidx.compose.ui:ui-tooling"
        const val composeMaterial3 =
            "androidx.compose.material3:material3:${Versions.composeMaterial3Version}"
        const val composeNavigation =
            "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}"
        const val composeIcons =
            "androidx.compose.material:material-icons-extended:${Versions.composeIcons}"
        const val lifecycleComposeRuntime =
            "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleComposeRuntime}"
    }

    object UiUtil {
        const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"
        const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"
    }
}
