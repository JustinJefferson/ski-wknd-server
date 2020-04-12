name := """ski-wknd-server"""
organization := "com.justin"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  guice,
  "mysql" % "mysql-connector-java" % "5.1.46",
)
