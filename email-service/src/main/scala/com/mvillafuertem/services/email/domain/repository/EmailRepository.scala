package com.mvillafuertem.services.email.domain.repository

import scala.concurrent.Future

trait EmailRepository {

  def save(message: String): Future[Unit]

}
