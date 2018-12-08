package com.mvillafuertem.services.email.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.mvillafuertem.services.email.application.{EmailFinder, EmailSender}
import com.mvillafuertem.services.email.domain.model.Email
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

import scala.concurrent.Future

final class EmailController(emailSender: EmailSender, emailFinder: EmailFinder) extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val emailFormat: RootJsonFormat[Email] = jsonFormat3(Email.apply(_: String, _: String, _: String))

  val emailRoutes: Route = get {
    get {
      pathPrefix("email" / LongNumber) { id =>
        val maybeEmail: Future[Option[Email]] = emailFinder.find(id)

        onSuccess(maybeEmail) {
          case Some(email) => complete(email)
          case None       => complete(StatusCodes.NotFound)
        }
      }
    } ~
      post {
        path("email") {
          entity(as[Email]) { email =>
            val saved: Future[Email] = emailSender(email)
            onComplete(saved) { done =>
              complete(s"email sended $done")
            }

          }
        }
      }

  }
}
