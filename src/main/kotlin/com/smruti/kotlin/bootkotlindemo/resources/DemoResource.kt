package com.smruti.kotlin.bootkotlindemo.resources

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DemoResource{
    @GetMapping(value="/")
    fun sayHelloWorld() = "Hello World";
}
