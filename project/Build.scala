import sbt._
import Keys._

object MultiBuild extends Build {
  val commonSettings = Seq(
    version := "0.1-SNAPSHOT",
    organization := "com.foo",
    scalaVersion := "2.9.1",
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  )

  lazy val subone = Project(id = "subone", base = file("subone")).settings (commonSettings : _*)
  lazy val subtwo = Project(id = "subtwo", base = file("subtwo")).settings (commonSettings : _*) dependsOn (subone)

  lazy val multibuild = Project(id = "MultiBuild", base = file(".")).settings (commonSettings : _*) aggregate(subone, subtwo)  
}
