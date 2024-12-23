import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// Arquivo de build de nível superior onde você pode adicionar opções de configuração comuns a todos os subprojetos/módulos.


plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("androidx.navigation.safeargs") version "2.8.4" apply false
    id("com.github.ben-manes.versions") version "0.51.0" apply true
}

/*
id("com.android.application") version "8.7.2" apply false
id("com.android.library") version "8.7.2" apply false
id("org.jetbrains.kotlin.android") version "2.0.21" apply false
id("com.google.gms.google-services") version "4.4.2" apply false
id("androidx.navigation.safeargs") version "2.8.4" apply false
id("com.github.ben-manes.versions") version "0.51.0" apply true
*/
allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

fun isNonStable(candidate: ModuleComponentIdentifier): Boolean {
    return listOf("alpha", "beta", "rc", "snapshot").any { keyword ->
        keyword in candidate.version.lowercase()
    }
}

fun isBlockListed(candidate: ModuleComponentIdentifier): Boolean {
    return listOf(
        "androidx.browser:browser",
        "com.google.android.gms:play-services-auth"
    ).any { keyword ->
        keyword in candidate.toString().lowercase()
    }
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate) || isBlockListed(candidate)
    }
}


tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}
