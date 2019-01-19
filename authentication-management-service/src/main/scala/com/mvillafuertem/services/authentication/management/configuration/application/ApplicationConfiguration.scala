package com.mvillafuertem.services.authentication.management.configuration.application

import com.mvillafuertem.services.authentication.management.application.service.AuthenticateUser
import com.mvillafuertem.services.authentication.management.configuration.infrastructure.InfrastructureConfiguration

import scala.concurrent.ExecutionContext

final class ApplicationConfiguration(infrastructureConfiguration: InfrastructureConfiguration)(implicit executionContext: ExecutionContext) {

  val userAuthenticator = new AuthenticateUser(infrastructureConfiguration.authenticationManagementRepository)
}
