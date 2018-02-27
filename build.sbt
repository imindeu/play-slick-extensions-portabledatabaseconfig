lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "eu.imind",
      scalaVersion := "2.12.4",
      version      := "0.1.0"
    )),
    name := "play-slick-extensions-portabledatabaseconfig",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-slick"	% "3.0.3"
    )
  )
