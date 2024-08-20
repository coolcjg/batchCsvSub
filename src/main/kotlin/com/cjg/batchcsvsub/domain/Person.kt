package com.cjg.batchcsvsub.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.io.Serializable
import java.time.LocalDateTime

@Entity
data class Person(

    @Id
    val customerId: String
    ,val firstName: String
    ,val lastName: String
    , val company: String
    , val city: String
    , val country: String
    , val phone1: String
    , val phone2: String
    , val email: String
    , val subscriptionDate: LocalDateTime
    , val website: String
): Serializable {
}
