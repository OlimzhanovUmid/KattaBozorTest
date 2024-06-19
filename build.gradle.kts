plugins {
    alias(libs.plugins.android.app) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.serializer) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
}

task("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}