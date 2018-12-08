package com.mvillafuertem.services.email.configuration

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.mvillafuertem.services.email.configuration.ActorExercises.Person.LivetheLife

object ActorExercises extends App {

  val system = ActorSystem("actorExercises")

  object Counter {

    case object Increment

    case object Decrement

    case object Print

  }

  class Counter extends Actor {

    import Counter._

    var count = 0

    override def receive: Receive = {
      case Increment => count += 1
      case Decrement => count -= 1
      case Print => println(s"Count: $count")
    }
  }

  import Counter._

  val counter = system.actorOf(Props[Counter], "myCounter")
  (1 to 5).foreach(_ => counter ! Increment)
  (1 to 3).foreach(_ => counter ! Decrement)
  counter ! Print


  object BankAccount {

    case class Deposit(amount: Int)

    case class Withdraw(amount: Int)

    case object Statement

    case class TransactionSuccess(message: String)

    case class TransactionFailure(reason: String)

  }

  class BankAccount extends Actor {

    import BankAccount._

    var funds = 0

    override def receive: Receive = {

      case Deposit(amount) =>
        if (amount < 0) sender() ! TransactionFailure("Invalid deposit amount")
        else {
          funds += amount
          sender() ! TransactionSuccess(s"Successfully deposited $amount")
        }
      case Withdraw(amount) =>
        if (amount < 0) sender() ! TransactionFailure("Invalid withdraw amount")
        else if (amount > funds) sender() ! TransactionFailure("Insufficient funds")
        else {
          funds -= amount
          sender() ! TransactionSuccess(s"Successfully withdrew $amount")
        }
      case Statement => sender() ! s"Your balance is $funds"

    }
  }

  object Person {

    case class LivetheLife(account: ActorRef)

  }

  class Person extends Actor {

    import BankAccount._
    import Person._

    override def receive: Receive = {
      case LivetheLife(account) =>
        account ! Deposit(10000)
        account ! Withdraw(90000)
        account ! Withdraw(500)
        account ! Statement
      case message => println(message.toString)
    }
  }

  val account = system.actorOf(Props[BankAccount], "bankAccount")
  val person = system.actorOf(Props[Person], "billionaire")

  person ! LivetheLife(account)

}







