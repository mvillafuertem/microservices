package com.mvillafuertem.services.authentication.management

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.mvillafuertem.services.authentication.management.api.AuthenticationManagementController
import com.mvillafuertem.services.authentication.management.configuration.ApplicationConfiguration.{actorSystemName, host, port}

import scala.concurrent.ExecutionContextExecutor
import scala.io.{Source, StdIn}

object AuthenticationManagementService extends App {

  override def main(args: Array[String]): Unit = {

    implicit val actorSystem: ActorSystem = ActorSystem(actorSystemName)
    implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

    val controller = new AuthenticationManagementController
    val bindingFuture = Http().bindAndHandle(controller.authenticationManagementRoutes, host, port)


    val banner = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("banner.txt"))
    for (elem <- banner.getLines()) {
      println(elem)
    }
    banner.close()
    StdIn.readLine()


    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => actorSystem.terminate())
  }
}
