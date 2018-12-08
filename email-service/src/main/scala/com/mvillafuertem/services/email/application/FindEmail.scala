package com.mvillafuertem.services.email.application
import com.mvillafuertem.services.email.domain.model.Email

import scala.concurrent.Future
import scala.util.Success

final class FindEmail extends EmailFinder {

  override def find(id: Long): Future[Option[Email]] = {

    case Success => Email.apply("email@email.com","Welcome!","Hi!, welcome to Akka")

  }
}
