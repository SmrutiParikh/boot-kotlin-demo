package com.smruti.kotlin.bootkotlindemo.service.impl

import com.smruti.kotlin.bootkotlindemo.dao.EmployeeRepository
import com.smruti.kotlin.bootkotlindemo.model.Employee
import reactor.core.publisher.Mono
import reactor.core.publisher.Flux
import org.springframework.beans.factory.annotation.Autowired
import com.smruti.kotlin.bootkotlindemo.service.IEmployeeService
import org.springframework.stereotype.Service


@Service
class EmployeeService : IEmployeeService {

    @Autowired
    internal var employeeRepo: EmployeeRepository? = null

    override fun create(e: Employee) {
        employeeRepo!!.save(e).subscribe()
    }

    override fun findById(id: Int?): Mono<Employee> {
        return employeeRepo!!.findById(id!!)
    }

    override fun findByName(name: String): Flux<Employee> {
        return employeeRepo!!.findByName(name)
    }

    override fun findAll(): Flux<Employee> {
        return employeeRepo!!.findAll()
    }

    override fun update(e: Employee): Mono<Employee> {
        return employeeRepo!!.save(e)
    }

    override fun delete(id: Int?): Mono<Void> {
        return employeeRepo!!.deleteById(id!!)
    }

}