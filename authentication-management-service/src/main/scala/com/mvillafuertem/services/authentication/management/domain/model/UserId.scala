package com.mvillafuertem.services.authentication.management.domain.model


object UserId {
  def apply(uuid: String): UserId = new UserId(uuid)
}

final case class UserId(uuid: String)
