package com.mvillafuertem.services.email.application
import akka.Done
import akka.actor.Status.Success
import com.mvillafuertem.services.email.domain.model.Email

import scala.concurrent.Future

final class SendEmail extends EmailSender {

  var emails: List[Email] = Nil

  override def send(email: Email): Future[Done] = {

    case Success => emails.aggregate(email)
  }
}
