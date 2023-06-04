@file:Suppress("UnstableApiUsage")

android {
    namespace = "${Config.packageName}commons_ui"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompilerVersion
    }
}

dependencies {

    implementation(Dependencies.Koin.koin)
    implementation(Dependencies.Koin.compose)

    implementation(Dependencies.Kotlin.coreKtx)
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.reflect)

    implementation(Dependencies.Support.androidXCore)
    implementation(Dependencies.Support.appCompat)
    implementation(Dependencies.Support.material)
    implementation(Dependencies.Support.constraintLayout)
    implementation(Dependencies.Support.animation)

    implementation(platform(Dependencies.Compose.composeBomVersion))
    implementation(Dependencies.Compose.composeUI)
    implementation(Dependencies.Compose.composeUITooling)
    implementation(Dependencies.Compose.composeUIToolingPreview)
    implementation(Dependencies.Compose.composeActivityCompose)
    implementation(Dependencies.Compose.composeMaterial3)
    implementation(Dependencies.Compose.lifecycleComposeRuntime)
    implementation(Dependencies.Compose.composeIcons)
    implementation(Dependencies.Compose.composeNavigation)

    implementation(Dependencies.UiUtil.lottie)
    implementation(Dependencies.UiUtil.coil)

    implementation(Dependencies.UnitTest.junit)
    implementation(Dependencies.UnitTest.runner)
    implementation(Dependencies.UnitTest.core)
    implementation(Dependencies.UnitTest.mockk)
    implementation(Dependencies.UnitTest.viewModelTest)

    implementation(Dependencies.AndroidTest.ext)
    implementation(Dependencies.AndroidTest.rules)
    implementation(Dependencies.AndroidTest.espresso)
    implementation(Dependencies.AndroidTest.intent)
    implementation(Dependencies.AndroidTest.runner)
    implementation(Dependencies.AndroidTest.hamcrest)
    implementation(Dependencies.AndroidTest.uiautomator)
}
