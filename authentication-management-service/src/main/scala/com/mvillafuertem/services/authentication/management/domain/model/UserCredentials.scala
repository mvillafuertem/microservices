package com.mvillafuertem.services.authentication.management.domain.model


object UserCredentials {
  def apply(key: String, secret: String): UserCredentials = new UserCredentials(key, secret)
}

final case class UserCredentials(key: String, secret: String)
