

## Navigáció

libs.versions.toml -be:

navigationCompose = "2.9.0"

navigation-compose = { module = "org.jetbrains.androidx.navigation:navigation-compose", version.ref = "navigationCompose" }

build.gradle.kts -be:

commonMain.dependencies {
    implementation(libs.navigation.compose)
}