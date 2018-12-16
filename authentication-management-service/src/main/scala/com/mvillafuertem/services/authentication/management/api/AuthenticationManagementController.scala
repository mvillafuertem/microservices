package com.mvillafuertem.services.authentication.management.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import spray.json.DefaultJsonProtocol

final class AuthenticationManagementController extends SprayJsonSupport with DefaultJsonProtocol {


  val authenticationManagementRoutes: Route =
    get {
      pathPrefix("") {
        complete("")
      }
    }
}
