package com.mvillafuertem.services.email.application
import akka.Done
import com.mvillafuertem.services.email.domain.infrastructure.EmailProducer
import com.mvillafuertem.services.email.domain.model.Email

import scala.concurrent.Future

final class SendEmail(emailProducer: EmailProducer) extends EmailSender {

  var emails: List[Email] = Nil

  override def send(email: Email): Future[Done] = {
    emails = emails :+ email
    Future.successful(Done)
  }
}
