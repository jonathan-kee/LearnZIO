ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "learnZIO"
  )

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.16"
)