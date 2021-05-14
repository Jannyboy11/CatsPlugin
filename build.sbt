val Name = "CatsPlugin"
val Version = "1.0.1"

name := Name
version := Version
scalaVersion := "2.13.5"

resolvers += "spigot-repo" at "https://hub.spigotmc.org/nexus/content/repositories/snapshots/"
resolvers += "jitpack" at "https://jitpack.io/"
resolvers += "bristermitten" at "https://repo.bristermitten.me/repository/maven-releases/"
resolvers += Resolver.mavenCentral
resolvers += Resolver.mavenLocal

libraryDependencies += "org.spigotmc" % "spigot-api" % "1.16.5-R0.1-SNAPSHOT" % "provided"
libraryDependencies += "com.github.Jannyboy11.ScalaPluginLoader" % "ScalaLoader" % "v0.14.5" % "provided"
libraryDependencies += "me.bristermitten" % "pdm" % "0.0.33-ScalaLoader"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.5.0" % "provided" //will be included by pdm

assemblyShadeRules in assembly := Seq(
    ShadeRule.rename("me.bristermitten.pdm.**" -> "com.janboerman.catsplugin.pdm.@1").inAll,
    ShadeRule.rename("me.bristermitten.pdmlibs.**" -> "com.janboerman.catsplugin.pdmlibs.@1").inAll
)
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false) //will be provided by ScalaLoader
assemblyJarName in assembly := Name + "-" + Version + ".jar"
