package com.mvillafuertem.services.loyalty.program.configuration.api

final class ApiConfiguration(applicationConfiguration: ApplicationConfiguration) {

  val controller = new AuthenticationManagementController(applicationConfiguration.userAuthenticator)

}
