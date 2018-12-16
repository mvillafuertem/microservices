package com.mvillafuertem.services.authentication.management.application.service

import com.mvillafuertem.services.authentication.management.application.UserAuthenticator
import com.mvillafuertem.services.authentication.management.domain.repository.AuthenticationManagementRepository

final class AuthenticateUser(authenticationManagementRepository: AuthenticationManagementRepository)
  extends UserAuthenticator {
  override def authenticate(): Unit = ???
}
