plugins {
    application
}

configure<JavaApplication> {
    mainClass.set("ru.itmo.java.client.Client")
}

tasks.register<Jar>("Jar") {
    dependsOn(configurations.runtimeClasspath)

    archiveClassifier.set("jar")
    manifest.attributes["Main-Class"] = application.mainClass.get()
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(sourceSets.main.get().output)
    from(
        configurations
            .runtimeClasspath
            .get()
            .filter { it.name.endsWith("jar") }
            .map(::zipTree)
    )

    doLast {
        copy {
            from(archiveFile)
            into(File(project.rootDir, "jars"))
        }
    }
}

dependencies {
    implementation(project(":common"))
}
