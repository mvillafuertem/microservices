package com.mvillafuertem.services.loyalty.program

import com.typesafe.config.ConfigFactory

object LoyaltyProgramServiceApplication extends App {

  override def main(args: Array[String]): Unit = {

    val infrastructureConfiguration = new InfrastructureConfiguration
    val applicationConfiguration = new ApplicationConfiguration(infrastructureConfiguration)
    val apiConfiguration = new ApiConfiguration(applicationConfiguration)

    val authenticationManagementProperties = new AuthenticationManagementProperties(ConfigFactory.load("application"))
    val authenticationManagementConfiguration = new AuthenticationManagementConfiguration(authenticationManagementProperties, apiConfiguration)

    authenticationManagementConfiguration.init()
  }

}
