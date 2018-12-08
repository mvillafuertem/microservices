package com.mvillafuertem.services.email.domain

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.mvillafuertem.services.email.domain.ChangingActorBehavior.FussyKid.{KidAccept, KidReject}

object ChangingActorBehavior extends App {


  object FussyKid {

    case object KidAccept

    case object KidReject

    val HAPPY = "happy"
    val SAD = "sad"
  }

  class FussyKid extends Actor {

    import FussyKid._
    import Mom._

    var state = HAPPY

    override def receive: Receive = {
      case Food(VEGETABLE) => state = SAD
      case Food(CHOCOLATE) => state = HAPPY
      case Ask(_) =>
        if (state == HAPPY )sender() ! KidAccept
        else sender() ! KidReject
    }
  }

  object Mom {

    case class MomStart(kidRef: ActorRef)
    case class Food(food: String)
    case class Ask(message: String)

    val VEGETABLE = "veggies"
    val CHOCOLATE = "chocolate"
  }

  class Mom extends Actor {
    import Mom._
    override def receive: Receive = {
      case MomStart(kidRef) =>
        kidRef ! Food(VEGETABLE)
        kidRef ! Ask("Do you want to play?")
      case KidAccept => println("Yay, my kid is happy!")
      case KidReject => println("My kid is sad, but he's healthy")
    }

    val system = ActorSystem("changingActorBehavior")
    val fussyKid = system.actorOf(Props[FussyKid])
    val mom = system.actorOf(Props[Mom])

    mom ! MomStart(fussyKid)
  }

}
