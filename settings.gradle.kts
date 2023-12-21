pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
        maven {
            url = uri("http://10.1.1.9:8081/repository/maven-releases/")
            isAllowInsecureProtocol = true
        }
        maven {
            url = uri("http://10.1.1.9:8081/repository/maven-snapshots")
            isAllowInsecureProtocol = true
        }
    }
}

rootProject.name = "ComposeTest"
include(":app")
include(":managespace")
include(":soldier")
