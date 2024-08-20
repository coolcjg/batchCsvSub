package com.cjg.batchcsvsub.kafka.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig {

    @Value(value="\${spring.kafka.bootstrap-servers}")
    lateinit var bootstrapAddresse : String

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val config = HashMap<String,Any>()
        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddresse
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        return DefaultKafkaProducerFactory(config)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String>{
        return KafkaTemplate(producerFactory());
    }


}