package com.mvillafuertem.services.loyalty.program.configuration

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor
import scala.io.{Source, StdIn}

final class AuthenticationManagementConfiguration(applicationProperties: AuthenticationManagementProperties,
                                                  apiConfiguration: ApiConfiguration) {

  implicit val actorSystem: ActorSystem = ActorSystem(applicationProperties.actorSystemName)
  implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

  private def loadBanner(): Unit = {
    val banner = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("banner.txt"))
    for (line <- banner.getLines()) {
      println(line)
    }
    banner.close()
    println("Press enter to stop application...")
  }

  val init: Unit = {

    val bindingFuture = Http().bindAndHandle(apiConfiguration.controller.authenticationManagementRoutes, applicationProperties.host, applicationProperties.port)

    loadBanner()
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => actorSystem.terminate())
  }
}
