package com.mvillafuertem.services.email.domain.model

object User {

  def apply(id: String, name: String, email: String, phone: String): User = new User(id, name, email, phone)

}

final case class User(id: String, name: String, email: String, phone: String)
