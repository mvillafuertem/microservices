package com.mvillafuertem.services.authentication.management.domain.model


object User {
  def apply(userId: UserId, userCredentials: UserCredentials): User = new User(userId, userCredentials)
}

final case class User(userId: UserId, userCredentials: UserCredentials)
