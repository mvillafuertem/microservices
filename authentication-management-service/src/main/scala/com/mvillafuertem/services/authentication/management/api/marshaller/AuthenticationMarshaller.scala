package com.mvillafuertem.services.authentication.management.api.marshaller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.mvillafuertem.services.authentication.management.domain.model.{User, UserCredentials, UserId}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}


trait AuthenticationMarshaller extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val userCredentialsFormat: RootJsonFormat[UserCredentials] = jsonFormat2(UserCredentials.apply(_: String, _: String))
  implicit val userIdFormat: RootJsonFormat[UserId] = jsonFormat1(UserId.apply(_: String))
  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User.apply(_: UserId, _: UserCredentials))
}