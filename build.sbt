import sbt._
lazy val commonSettings = Seq(
	version := "1.0",
	scalaVersion := "2.11.6",
	resolvers += Resolver.sonatypeRepo("releases"),
	libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _),
	libraryDependencies += "org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full,
	addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)
)

lazy val utils = (project in file("utils")).settings(commonSettings: _*)

lazy val root = (project in file(".")).settings(commonSettings: _*).dependsOn(utils)
