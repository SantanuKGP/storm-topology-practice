ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "first-storm-lib"
  )

val logbackVersion = "1.2.10"
val slf4j_version = "1.7.5"
val log4j_api_version = "2.17.2"
val StormV = "1.0.2"



//val additionalResolvers = Seq(
//  "typesafe-repository" at "https://repo.typesafe.com/typesafe/releases/",
//  "clojars-repository" at "https://clojars.org/repo",
//  "twttr" at "https://maven.twttr.com"
//)

//scalacOptions += "-Yresolve-term-conflict:package"

libraryDependencies ++= Seq(
//  "org.apache.storm"      % "storm-core" % StormV % "provided" exclude ("javax.servlet", "servlet-api"),
  "org.apache.storm" % "storm-core" % StormV % "provided",
  "org.apache.storm"      % "storm-kafka-client" % StormV,
  "org.apache.zookeeper" % "zookeeper" % "3.7.1",
//  "org.slf4j" % "slf4j-api" % slf4j_version,
//  "org.slf4j" % "slf4j-simple" % "1.6.4",
//  "org.apache.logging.log4j" % "log4j-api" % log4j_api_version,
//  "ch.qos.logback" % "logback-classic" % logbackVersion,
)

