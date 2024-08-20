package com.cjg.batchcsvsub.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducer(
    val kafkaTemplate:KafkaTemplate<String, String>
) {

    fun create(topic:String, message : String){
        val future = kafkaTemplate.send(topic, message)

        future.whenComplete { _, _ ->
            println("pub : $message")
        }

    }
}