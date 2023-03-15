dependencyResolutionManagement {
	versionCatalogs {
		create("baseLibs") {
			from(files("base.libs.versions.toml"))
		}
		create("androidLibs") {
			from(files("android.libs.versions.toml"))
		}
	}
	repositories {
		google()
		mavenCentral()
	}
}
