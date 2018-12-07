import sbt._

object Dependencies {

  object Versions {

    val akka = "2.5.12"
    val akkaHttp = "10.1.5"
  }

  val production = Seq(

    "com.typesafe.akka" %% "akka-http" % Versions.akkaHttp,
    "com.typesafe.akka" %% "akka-stream" % Versions.akka
  )

  val test = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )
}
