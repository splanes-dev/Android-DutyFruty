import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

enum class ProjectType {
    Application,
    Library,
}

inline val Project.isApp get() = name.contains("app", ignoreCase = true)

inline val Project.type get() = if (isApp) ProjectType.Application else ProjectType.Library

fun Project.androidConfig(config: com.android.build.gradle.BaseExtension.() -> Unit) {
    configure<com.android.build.gradle.BaseExtension> { config() }
}
