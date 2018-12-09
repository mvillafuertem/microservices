package com.mvillafuertem.services.email

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.mvillafuertem.services.email.api.EmailController
import com.mvillafuertem.services.email.application.{FindEmail, SendEmail}
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object EmailServiceApplication extends App {


  override def main(args: Array[String]): Unit = {

    val applicationConfiguration = ConfigFactory.load("application")

    val host = applicationConfiguration.getString("server.host")
    val port = applicationConfiguration.getInt("server.port")
    val actorSystemName = applicationConfiguration.getString("actor-system-name")


    implicit val actorSystem: ActorSystem = ActorSystem(actorSystemName)
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

    val routes = new EmailController(new SendEmail, new FindEmail)

    val bindingFuture = Http().bindAndHandle(routes.emailRoutes, host, port)

    println("Started EmailServiceApplication...")
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => actorSystem.terminate())

  }
}
