plugins {
    java
    application
}

group = "com.rachel"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("com.rachel.mediaplayer.MediaPlayerApp")
}

tasks.register<Jar>("runnableJar") {
    archiveBaseName.set("InteractiveMediaPlayer")
    archiveVersion.set("1.0")
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
    from(sourceSets.main.get().output)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
