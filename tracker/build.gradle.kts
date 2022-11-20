plugins {
    application
}

configure<JavaApplication> {
    mainClass.set("ru.itmo.java.tracker.TorrentTracker")
}

dependencies {
    implementation(project(":common"))
}
