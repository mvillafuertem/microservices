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

    val applicationConfiguration = ConfigFactory.load("")
    val serverConfiguration = ConfigFactory.load("")


    val host = serverConfiguration.getString("")
    val port = serverConfiguration.getInt("")

    implicit val actorSystem: ActorSystem = ActorSystem(applicationConfiguration.getString(""))
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

    val routes = new EmailController(new SendEmail, new FindEmail)

    val bindingFuture = Http().bindAndHandle(routes.emailRoutes, host, port)


    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => actorSystem.terminate())

  }
}
