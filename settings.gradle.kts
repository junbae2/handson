rootProject.name = "handson"

fileTree(".") {
    include("**/build.gradle")
    include("**/build.gradle.kts")
    exclude("buildSrc/**")
    exclude("build.gradle.kts")
}.map {
    relativePath(it.parent)
}.forEach {
    val project = ":${it.substringAfterLast(File.separator)}"
    val projectDir = "$rootDir/$it"
    println("sub projects - $project, $projectDir")
    include(project)
    project("$project").projectDir = File(projectDir)
}