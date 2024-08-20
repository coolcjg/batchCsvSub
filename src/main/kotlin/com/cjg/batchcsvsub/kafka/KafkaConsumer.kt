package com.cjg.batchcsvsub.kafka

import com.cjg.batchcsvsub.domain.Person
import com.cjg.batchcsvsub.repository.PersonRepository
import com.google.gson.JsonParser
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class KafkaConsumer(
    private val personRepository: PersonRepository
) {

    @KafkaListener(topics = ["bulk"])
    fun listener(@Payload data:String){
        personRepository.save(convert(data))
    }

    fun convert(value:String) : Person {
        val jo = JsonParser.parseString(value).asJsonObject;
        val customerId = jo.get("customerId").asString
        val firstName = jo.get("firstName").asString
        val lastName = jo.get("lastName").asString
        val company = jo.get("company").asString
        val city = jo.get("city").asString
        val country = jo.get("country").asString
        val phone1 = jo.get("phone1").asString
        val phone2 = jo.get("phone2").asString
        val email = jo.get("email").asString
        val subscriptionDate = LocalDateTime.parse(jo.get("subscriptionDate").asString
                                                    , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        val website = jo.get("website").asString

        println(jo.get("index").asString + ", " + LocalDateTime.now())

        val person = Person(customerId, firstName, lastName, company, city, country, phone1, phone2, email, subscriptionDate, website)
        return person

    }

}