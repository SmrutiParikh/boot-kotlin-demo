package com.smruti.kotlin.bootkotlindemo

import com.smruti.kotlin.bootkotlindemo.utils.Constants
import com.smruti.kotlin.bootkotlindemo.utils.userData
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BootKotlinDemoApplication

fun main(args: Array<String>) {
    //runApplication<BootKotlinDemoApplication>(*args)
    SpringApplication.run(BootKotlinDemoApplication::class.java, *args)
    println(Constants.title)
    println(Constants.DbConstants.TABLE_USER_ATTRIBUTE_DATA)
    println(userData)
    Constants().foo

}
