plugins {
    kotlin("jvm") version "1.7.20"
}

dependencies {
    implementation(project(":utils"))

    implementation(libs.datetime)
    implementation(libs.bundles.test)
}
