import java.time.Instant

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("myTaskClean") {
    doLast {
        println("Start clean ${Instant.now().epochSecond}")
    }
    dependsOn(":app:clean")
    doLast {
        println("End clean ${Instant.now().epochSecond}")
    }
}

tasks.register("myTaskAssemble") {
    doLast {
        println("Start assemble ${Instant.now().epochSecond}")
    }
    dependsOn(":app:assemble")
    doLast {
        println("End assemble ${Instant.now().epochSecond}")
    }
}

tasks.register("myTaskCheck") {
    doLast {
        println("Start check ${Instant.now().epochSecond}")
    }
    dependsOn(":app:check")
    doLast {
        println("Start check ${Instant.now().epochSecond}")
    }
}

tasks.register("zzz") {
    doLast {
        throw Exception("Game over")
    }
}

tasks.register("pullRequest") {
    dependsOn("myTaskClean")
    dependsOn("myTaskAssemble")
    dependsOn("myTaskCheck")
    dependsOn("zzz")

    tasks.getByName("myTaskAssemble").mustRunAfter("myTaskClean")
    tasks.getByName("myTaskCheck").mustRunAfter("myTaskAssemble")
    tasks.getByName("zzz").mustRunAfter("myTaskCheck")
}

gradle.taskGraph.beforeTask {
    println("executing $this ${Instant.now().epochSecond}...")
}

gradle.taskGraph.afterTask {
    println("done $this ${Instant.now().epochSecond}")
}
