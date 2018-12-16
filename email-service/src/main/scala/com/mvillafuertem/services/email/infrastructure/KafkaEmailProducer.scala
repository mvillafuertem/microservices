package com.mvillafuertem.services.email.infrastructure

import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.scaladsl.Source
import com.mvillafuertem.services.email.domain.infrastructure.EmailProducer
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

final class KafkaEmailProducer(producerSettings: ProducerSettings[String, String]) extends EmailProducer {

  val topic: String = ???

  override def produce(id: String): String = {
    Source(1 to 100)
      .map(_.toString)
      .map(value => new ProducerRecord[String, String](topic, value))
      .runWith(Producer.plainSink(producerSettings))
  }
}
