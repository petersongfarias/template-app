import Dependencies.modules

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Gradle.kotlinPlugin)
        classpath(Dependencies.Gradle.kotlinGradlePlugin)
        classpath(Dependencies.Gradle.androidTools)
        classpath(
            kotlin(
                Dependencies.Gradle.gradlePlugin,
                Versions.kotlin_version,
            ),
        )
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = uri("https://oss.sonatype.org/content/repositories/snapshots/"))
    }
    configureAndroid()
}

fun Project.configureAndroid() {
    val isAppModule = name == "app"

    when {
        isAppModule -> configureAppAndroid()
        modules.contains(name) -> configureAndroidLibrary()
        else -> return
    }

    apply(plugin = "kotlin-android")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "kotlin-parcelize")

    configure<com.android.build.gradle.BaseExtension> {
        compileSdkVersion(Config.compileSdkVersion)
        buildToolsVersion(Config.buildToolsVersion)
        namespace = Config.applicationId

        testOptions.unitTests {
            isIncludeAndroidResources = true

            all { test ->
                with(test) {
                    testLogging {
                        events = setOf(
                            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
                            org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
                            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
                            org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT,
                            org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_ERROR,
                        )
                    }
                }
            }
        }

        defaultConfig {
            minSdk = Config.minSdkVersion
            targetSdk = Config.targetSdkVersion
            versionCode = Config.versionCode
            versionName = Config.versionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
            multiDexEnabled = true
        }

        lintOptions {
            isCheckReleaseBuilds = false
            isCheckDependencies = true
            isCheckAllWarnings = true
            isWarningsAsErrors = true
            isIgnoreWarnings = true
            isAbortOnError = false
            isQuiet = true
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        packagingOptions {
            resources {
                excludes += "META-INF/AL2.0"
                excludes += "META-INF/LGPL2.1"
            }
        }
    }
}

fun Project.configureAppAndroid() {
    apply(plugin = "com.android.application")

    configure<com.android.build.gradle.BaseExtension> {
        defaultConfig {
            applicationId = Config.applicationId
        }

        testOptions {
            animationsDisabled = true
        }

        buildTypes {
            getByName("debug") {
                isMinifyEnabled = false
                isTestCoverageEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro",
                )
                testProguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguardTest-rules.pro",
                )
            }
            getByName("release") {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro",
                )
                testProguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguardTest-rules.pro",
                )
            }
        }
    }
}

fun Project.configureAndroidLibrary() {
    apply(plugin = "com.android.library")
}

tasks.register("clean").configure {
    delete("build")
}
