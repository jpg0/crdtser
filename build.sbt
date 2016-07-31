name := "crdtser"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  )

resolvers ++= Seq(
)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
