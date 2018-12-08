import sbt._

object Dependencies {

  object Versions {

    val akka = "2.5.12"
    val akkaHttp = "10.1.5"
    val spray = "1.3.5"
  }

  val production = Seq(

    // Akka
    "com.typesafe.akka" %% "akka-http" % Versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % Versions.akkaHttp,
    "com.typesafe.akka" %% "akka-stream" % Versions.akka,

    // Spray
    "io.spray" %% "spray-json" % Versions.spray
  )

  val test = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )
}
