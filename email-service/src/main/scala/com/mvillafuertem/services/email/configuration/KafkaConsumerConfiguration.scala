package com.mvillafuertem.services.email.configuration

import akka.kafka.ConsumerSettings
import com.typesafe.config.Config
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer

final class KafkaConsumerConfiguration(config: Config) {
  ConsumerSettings(config, new StringDeserializer, new StringDeserializer)
    .withBootstrapServers(config.getString(""))
    .withGroupId(config.getString(""))
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, config.getString(""))
}
