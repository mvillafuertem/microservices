package com.mvillafuertem.services.authentication.management.configuration.api

import com.mvillafuertem.services.authentication.management.api.controller.AuthenticationManagementController
import com.mvillafuertem.services.authentication.management.configuration.application.ApplicationConfiguration

final class ApiConfiguration(applicationConfiguration: ApplicationConfiguration) {

  val controller = new AuthenticationManagementController(applicationConfiguration.userAuthenticator)

}
