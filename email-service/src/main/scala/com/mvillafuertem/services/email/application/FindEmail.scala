package com.mvillafuertem.services.email.application
import com.mvillafuertem.services.email.domain.model.Email

import scala.concurrent.Future

final class FindEmail extends EmailFinder {

  override def find(id: Long): Future[Option[Email]] = {
    Future.successful(Option(Email("email@email.com","Welcome!","Hi!, welcome to Akka")))
  }
}
