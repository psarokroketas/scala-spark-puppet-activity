name := "spark-puppet-activity"

version := "1.0"

scalaVersion := "2.11.11"

val sparkVersion = "2.3.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion changing(),
  "org.apache.spark" %% "spark-sql" % sparkVersion changing(),
  "org.apache.spark" %% "spark-streaming" % sparkVersion changing(),
  "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion changing(),
  "com.github.scopt" %% "scopt" % "3.7.0",
  "org.json4s" %% "json4s-native" % "3.2.10",
  "org.scalaj" %% "scalaj-http" % "2.3.0"
)

resolvers ++= Seq(
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  "Mesosphere Public Repository" at "http://downloads.mesosphere.io/maven",
  "Apache Snapshot" at "https://repository.apache.org/content/repositories/snapshots/",
  Resolver.sonatypeRepo("public"),
)

updateOptions := updateOptions.value.withLatestSnapshots(false)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

publishTo := Some(Resolver.file("file",  new File( "release" )) )

