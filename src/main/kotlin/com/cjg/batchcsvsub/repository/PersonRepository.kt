package com.cjg.batchcsvsub.repository

import com.cjg.batchcsvsub.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PersonRepository : JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    fun save(person:Person) : Person
}