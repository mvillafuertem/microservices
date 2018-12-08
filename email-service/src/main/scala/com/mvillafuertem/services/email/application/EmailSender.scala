package com.mvillafuertem.services.email.application

import akka.Done
import com.mvillafuertem.services.email.domain.model.Email

import scala.concurrent.Future

trait EmailSender {

  def send(email: Email): Future[Done]

}
