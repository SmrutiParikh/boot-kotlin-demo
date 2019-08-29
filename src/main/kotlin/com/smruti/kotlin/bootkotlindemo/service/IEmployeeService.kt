package com.smruti.kotlin.bootkotlindemo.service

import com.smruti.kotlin.bootkotlindemo.model.Employee

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IEmployeeService {
    fun create(e: Employee)

    fun findById(id: Int?): Mono<Employee>

    fun findByName(name: String): Flux<Employee>

    fun findAll(): Flux<Employee>

    fun update(e: Employee): Mono<Employee>

    fun delete(id: Int?): Mono<Void>
}