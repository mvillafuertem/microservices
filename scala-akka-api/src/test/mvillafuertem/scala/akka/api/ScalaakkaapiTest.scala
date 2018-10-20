package mvillafuertem.scala.akka.api

import org.scalatest._
import org.scalatest.Matchers._

final class ScalaakkaapiTest extends WordSpec with GivenWhenThen {
  private val routesWithDefinedResponses =
    get {
      path("status") {
        complete(HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}"""))
      }
    }



  "Scalaakkaapi" should {
    "greet" in {
      Given("a Scalaakkaapi")

      val scalaakkaapi = new Scalaakkaapi

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting = scalaakkaapi.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
