val scala3Version = "3.0.0"
val AkkaVersion = "2.6.14"

lazy val root = project
  .in(file("."))
  .enablePlugins(JmhPlugin)
  .settings(
    name := "scala3-simple",
    version := "0.1.0",
    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
        "org.graalvm.sdk" % "graal-sdk" % "21.1.0" % "provided",
        "ch.qos.logback" % "logback-classic" % "1.2.3"
    )
  )

