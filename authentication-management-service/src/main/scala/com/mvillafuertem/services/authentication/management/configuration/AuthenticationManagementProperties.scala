package com.mvillafuertem.services.authentication.management.configuration

import com.typesafe.config.Config

final class AuthenticationManagementProperties(config: Config) {

  // ActorSystem
  val actorSystemName: String = config.getString("actor-system-name")

  // Server
  val host: String = config.getString("server.host")
  val port: Int = config.getInt("server.port")

}
