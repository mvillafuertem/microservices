package com.mvillafuertem.services.email

import akka.actor.{Actor, ActorSystem, Props}

object EmailServiceApplication extends App {

  val actorSystem = ActorSystem("firtsActorSystem")

  println(actorSystem)

  class WordCountActor extends Actor {

    var totalWords = 0

    override def receive: Receive = {
      case message: String =>
        println(s"[word counter] I have received: ${message.toString}")
        totalWords += message.split(" ").length
      case message => println(s"[word counter] I cannot undertand ${message.toString}")
    }
  }

  val wordCounter = actorSystem.actorOf(Props[WordCountActor], "wordCounter")
  val anotherCounter = actorSystem.actorOf(Props[WordCountActor], "anotherWordCounter")

  wordCounter ! "I am Learning Akka and it's pretty damn cool!"
  anotherCounter ! "A different message!"

  class Person(name: String) extends Actor {
    override def receive: Receive = {
      case "hi" => println(s"Hi, my name is $name")
    }
  }

  val person = actorSystem.actorOf(Props(new Person("Bob")))

  person ! "hi"
}
