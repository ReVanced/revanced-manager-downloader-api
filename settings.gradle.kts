pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
        mavenLocal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        mavenLocal()
        maven {
            // A repository must be specified for some reason. "registry" is a dummy.
            url = uri("https://maven.pkg.github.com/revanced/registry")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: extra["gpr.user"] as String?
                password = System.getenv("GITHUB_TOKEN") ?: extra["gpr.key"] as String?
            }
        }
    }
}
buildCache {
    local {
        isEnabled = "CI" !in System.getenv()
    }
}
rootProject.name = "manager-downloader-plugin"
include(":manager-downloader-plugin", ":example")
