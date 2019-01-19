package com.mvillafuertem.services.authentication.management.api.controller

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.mvillafuertem.services.authentication.management.api.AuthenticationManagement
import com.mvillafuertem.services.authentication.management.api.marshaller.AuthenticationMarshaller
import com.mvillafuertem.services.authentication.management.application.UserAuthenticator

final class AuthenticationManagementController(userAuthenticator: UserAuthenticator)
  extends AuthenticationManagement
    with AuthenticationMarshaller {

  val authenticationManagementRoutes: Route =
    get {
      pathPrefix("authenticate") {
        complete(userAuthenticator.authenticate())
      }
    } ~
      get {
        path("health") {
          complete(HttpEntity(ContentTypes.`application/json`, """{"status": "UP"}"""))
        }
      }
}
