import sbt.Path

name := "myscala"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  ("org.apache.commons" % "commons-io" % "1.3.2")
)


javacOptions ++= Seq("-encoding", "UTF-8")
scalacOptions ++= Seq("-encoding", "UTF-8")
scalacOptions ++= Seq("-feature", "-language:_")
scalacOptions ++= Seq("-Xlint", "-unchecked")
scalacOptions ++= Seq("-deprecation")
scalacOptions += "-Ylog-classpath"