package com.mvillafuertem.services.authentication.management.application.service

import java.util.UUID

import com.mvillafuertem.services.authentication.management.application.UserAuthenticator
import com.mvillafuertem.services.authentication.management.domain.model.{User, UserCredentials, UserId}
import com.mvillafuertem.services.authentication.management.domain.repository.AuthenticationManagementRepository

import scala.concurrent.{ExecutionContext, Future}

final class AuthenticateUser(authenticationManagementRepository: AuthenticationManagementRepository)(implicit executionContext: ExecutionContext)
  extends UserAuthenticator {

  val userId: UserId = UserId(UUID.randomUUID().toString)

  val userCredentials: UserCredentials = UserCredentials("key", "secret")

  override def authenticate(): Future[User] = Future {

    User(userId, userCredentials)
  }
}
