lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "eu.imind.play",
      scalaVersion := "2.12.4",
      version      := "0.1.0"
    )),
    name := "play-slick-extensions-portabledatabaseconfig",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-slick"	% "3.0.3"
    )
  )
