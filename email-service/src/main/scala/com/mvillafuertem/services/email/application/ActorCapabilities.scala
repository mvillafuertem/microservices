package com.mvillafuertem.services.email.application

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object ActorCapabilities extends App {

  class SimpleActor extends Actor {
    override def receive: Receive = {
      case "Hi" => context.sender() ! "Hello, there!"
      case message: String => println(s"[${context.self.path}] I have received $message")
      case SayHiTo(ref) => ref ! "Hi"
      case PhoneMessage(content, ref) => ref forward (content + " forward")
    }
  }

  val system = ActorSystem("actorCapabilities")
  val simpleActor = system.actorOf(Props[SimpleActor], "simpleActor")

  simpleActor ! "Hello, actor"


  val alice = system.actorOf(Props[SimpleActor], "alice")
  val bob = system.actorOf(Props[SimpleActor], "bob")

  case class SayHiTo(ref: ActorRef)

  alice ! SayHiTo(bob)


  case class PhoneMessage(content: String, actorRef: ActorRef)


  alice ! PhoneMessage("Hi all", bob)

}
