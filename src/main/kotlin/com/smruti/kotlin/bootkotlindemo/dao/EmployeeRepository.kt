package com.smruti.kotlin.bootkotlindemo.dao

import com.smruti.kotlin.bootkotlindemo.model.Employee
import org.springframework.data.mongodb.repository.Query
import reactor.core.publisher.Flux
import org.springframework.data.mongodb.repository.ReactiveMongoRepository


interface EmployeeRepository : ReactiveMongoRepository<Employee, Int> {
    @Query("{ 'name': ?0 }")
    fun findByName(name: String): Flux<Employee>
}