package com.mvillafuertem.services.email.api

import akka.Done
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.mvillafuertem.services.email.application.{EmailFinder, EmailSender}
import com.mvillafuertem.services.email.domain.model.Email
import com.mvillafuertem.services.email.infrastructure.marshaller.EmailJsonFormatMarshaller._
import spray.json.DefaultJsonProtocol

import scala.concurrent.Future

final class EmailController(emailSender: EmailSender, emailFinder: EmailFinder) extends SprayJsonSupport with DefaultJsonProtocol {


  val emailRoutes: Route = get {
    get {
      pathPrefix("email" / LongNumber) { id =>
        val maybeEmail: Future[Option[Email]] = emailFinder.find(id)

        onSuccess(maybeEmail) {
          case Some(email) => complete(email)
          case None        => complete(StatusCodes.NotFound)
        }
      }
    } ~
      post {
        path("email") {
          entity(as[Email]) { email =>
            val saved: Future[Done] = emailSender.send(email)
            onComplete(saved) { done =>
              complete(s"email sended $done")
            }

          }
        }
      }

  }
}
