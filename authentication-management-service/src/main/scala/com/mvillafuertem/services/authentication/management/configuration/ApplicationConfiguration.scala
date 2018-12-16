package com.mvillafuertem.services.authentication.management.configuration

import com.typesafe.config.ConfigFactory

object ApplicationConfiguration {

  private val configuration = ConfigFactory.load("application")
  val host: String = configuration.getString("server.host")
  val port: Int = configuration.getInt("server.port")
  val actorSystemName: String = configuration.getString("actor-system-name")

}
