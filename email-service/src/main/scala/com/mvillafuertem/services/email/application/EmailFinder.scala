package com.mvillafuertem.services.email.application

import com.mvillafuertem.services.email.domain.model.Email

import scala.concurrent.Future

trait EmailFinder {
  def find(id: Long): Future[Option[Email]]

}
