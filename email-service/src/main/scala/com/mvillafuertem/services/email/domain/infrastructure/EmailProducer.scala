package com.mvillafuertem.services.email.domain.infrastructure

trait EmailProducer {

  def produce(id: String): String

}
