package com.mvillafuertem.services.loyalty.program.api.controller

import com.mvillafuertem.services.loyalty.program.api.LoyaltyAPI

final class LoyaltyController(userAuthenticator: UserAuthenticator)
  extends LoyaltyAPI
    with SprayJsonSupport
    with DefaultJsonProtocol {

  val authenticationManagementRoutes: Route =
    get {
      pathPrefix("") {
        complete("")
      }
    }
}
