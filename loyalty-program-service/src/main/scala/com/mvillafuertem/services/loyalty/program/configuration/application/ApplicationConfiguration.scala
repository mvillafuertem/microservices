package com.mvillafuertem.services.loyalty.program.configuration.application

final class ApplicationConfiguration(infrastructureConfiguration: InfrastructureConfiguration) {

  val userAuthenticator = new AuthenticateUser(infrastructureConfiguration.authenticationManagementRepository)
}
