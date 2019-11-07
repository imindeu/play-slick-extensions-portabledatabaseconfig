lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "eu.imind.play",
      scalaVersion := "2.13.0",
      version      := "4.0.2"
    )),
    name := "play-slick-extensions-portabledatabaseconfig",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-slick"	% "4.0.2"
    )
  )
