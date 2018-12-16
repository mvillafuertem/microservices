package com.mvillafuertem.services.authentication.management

import com.mvillafuertem.services.authentication.management.configuration.api.ApiConfiguration
import com.mvillafuertem.services.authentication.management.configuration.application.ApplicationConfiguration
import com.mvillafuertem.services.authentication.management.configuration.infrastructure.InfrastructureConfiguration
import com.mvillafuertem.services.authentication.management.configuration.{AuthenticationManagementConfiguration, AuthenticationManagementProperties}
import com.typesafe.config.ConfigFactory

object AuthenticationManagementService extends App {

  override def main(args: Array[String]): Unit = {

    val infrastructureConfiguration = new InfrastructureConfiguration
    val applicationConfiguration = new ApplicationConfiguration(infrastructureConfiguration)
    val apiConfiguration = new ApiConfiguration(applicationConfiguration)

    val authenticationManagementProperties = new AuthenticationManagementProperties(ConfigFactory.load("application"))
    val authenticationManagementConfiguration = new AuthenticationManagementConfiguration(authenticationManagementProperties, apiConfiguration)

    authenticationManagementConfiguration.init()
  }

}
