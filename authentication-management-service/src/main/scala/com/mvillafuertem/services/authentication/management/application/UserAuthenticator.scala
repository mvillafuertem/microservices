package com.mvillafuertem.services.authentication.management.application

import com.mvillafuertem.services.authentication.management.domain.model.User

import scala.concurrent.Future

trait UserAuthenticator {

  def authenticate(): Future[User]

}
