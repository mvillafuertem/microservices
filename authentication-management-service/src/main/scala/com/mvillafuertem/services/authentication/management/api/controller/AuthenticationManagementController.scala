package com.mvillafuertem.services.authentication.management.api.controller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.mvillafuertem.services.authentication.management.api.AuthenticationManagement
import com.mvillafuertem.services.authentication.management.application.UserAuthenticator
import spray.json.DefaultJsonProtocol

final class AuthenticationManagementController(userAuthenticator: UserAuthenticator)
  extends AuthenticationManagement
    with SprayJsonSupport
    with DefaultJsonProtocol {

  val authenticationManagementRoutes: Route =
    get {
      pathPrefix("") {
        complete("")
      }
    }
}
