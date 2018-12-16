package com.mvillafuertem.services.email.infrastructure.repository

import com.mvillafuertem.services.email.domain.repository.EmailRepository

import scala.concurrent.Future

final class CassandraEmailRepository extends EmailRepository {

  override def save(message: String): Future[Unit] = ???
}
