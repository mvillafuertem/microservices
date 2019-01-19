package com.mvillafuertem.services.authentication.management

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.mvillafuertem.services.authentication.management.configuration.api.ApiConfiguration
import com.mvillafuertem.services.authentication.management.configuration.application.ApplicationConfiguration
import com.mvillafuertem.services.authentication.management.configuration.infrastructure.InfrastructureConfiguration
import com.mvillafuertem.services.authentication.management.configuration.{AuthenticationManagementConfiguration, AuthenticationManagementProperties}
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContext

object AuthenticationManagementServiceApplication extends App {

  override def main(args: Array[String]): Unit = {

    implicit val actorSystem: ActorSystem = ActorSystem()
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext:  ExecutionContext = actorSystem.dispatcher

    val infrastructureConfiguration = new InfrastructureConfiguration
    val applicationConfiguration = new ApplicationConfiguration(infrastructureConfiguration)
    val apiConfiguration = new ApiConfiguration(applicationConfiguration)

    val authenticationManagementProperties = new AuthenticationManagementProperties(ConfigFactory.load("application"))
    val authenticationManagementConfiguration = new AuthenticationManagementConfiguration(authenticationManagementProperties, apiConfiguration)

    authenticationManagementConfiguration.init
  }

}
