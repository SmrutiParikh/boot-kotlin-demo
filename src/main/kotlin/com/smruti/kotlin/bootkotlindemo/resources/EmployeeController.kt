package com.smruti.kotlin.bootkotlindemo.resources

import com.smruti.kotlin.bootkotlindemo.configs.kafka.KafkaConsumerConfig
import com.smruti.kotlin.bootkotlindemo.configs.kafka.KafkaProducerConfig
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.smruti.kotlin.bootkotlindemo.model.Employee;
import com.smruti.kotlin.bootkotlindemo.service.IEmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
class EmployeeController {
    @Autowired
    lateinit var employeeService : IEmployeeService;

    @Autowired
    lateinit var kafkaProducer : KafkaProducerConfig;

    @Autowired
    lateinit var kafkaConsumer : KafkaConsumerConfig;

    @PostMapping(value = [ "/produce" ])
    public fun produce(@RequestBody e : Employee) : HttpStatus{
        kafkaProducer.sendMessage(e.toString())
        return HttpStatus.CREATED
    }

    @GetMapping(value = [ "/consume" ])
    public fun consume() : String {
        return kafkaConsumer.consumedMsg.last()
    }

    @PostMapping(value = [ "/create", "/" ])
    public fun create(@RequestBody e : Employee) : HttpStatus{
        employeeService.create(e)
        return HttpStatus.CREATED
    }

    @GetMapping(value = ["/{id}"])
    public fun findById(@PathVariable("id") id : Int) : ResponseEntity<Mono<Employee>> {
        val e = employeeService.findById(id);
        val status = if( e != null ) {
            HttpStatus.OK
        }
        else{
            HttpStatus.NOT_FOUND
        }
        return ResponseEntity(e, status);
    }

    @GetMapping(value = ["/name/{name}"])
    public fun findByName(@PathVariable("name") name : String) : Flux<Employee> {
        return employeeService.findByName(name);
    }

    @GetMapping(produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    public fun findAll() : Flux<Employee>{
        val emps = employeeService.findAll();
        return emps;
    }

    @PutMapping(value = ["/update"])
    @ResponseStatus(HttpStatus.OK)
    public fun update(@RequestBody e : Employee) : Mono<Employee> {
        return employeeService.update(e);
    }

    @DeleteMapping(value = ["/delete/{id}"])
    public fun delete(@PathVariable("id") id : Int) : HttpStatus {
        employeeService.delete(id).subscribe()
        return HttpStatus.OK;
    }

}