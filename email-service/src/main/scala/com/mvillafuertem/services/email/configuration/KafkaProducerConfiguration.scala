package com.mvillafuertem.services.email.configuration

import akka.kafka.ProducerSettings
import com.typesafe.config.Config
import org.apache.kafka.common.serialization.StringSerializer

final class KafkaProducerConfiguration(config: Config) {

  ProducerSettings(config, new StringSerializer, new StringSerializer).withBootstrapServers(config.getString(""))

}