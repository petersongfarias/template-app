@file:Suppress("UnstableApiUsage")

android {
    namespace = "${Config.packageName}commons_network"
}

dependencies {

    implementation(Dependencies.Koin.koin)

    implementation(Dependencies.Kotlin.coreKtx)
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.reflect)

    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.coreOkhttp)
    implementation(Dependencies.Retrofit.interceptor)
    implementation(Dependencies.Retrofit.moshi)
    implementation(Dependencies.Retrofit.moshiConverter)

    implementation(Dependencies.UnitTest.core)
    implementation(Dependencies.UnitTest.junit)
    implementation(Dependencies.UnitTest.runner)
    implementation(Dependencies.UnitTest.mockk)

    implementation(Dependencies.AndroidTest.ext)
    implementation(Dependencies.AndroidTest.rules)
    implementation(Dependencies.AndroidTest.intent)
    implementation(Dependencies.AndroidTest.runner)
    implementation(Dependencies.AndroidTest.hamcrest)
    implementation(Dependencies.AndroidTest.mockWebServer)
}
