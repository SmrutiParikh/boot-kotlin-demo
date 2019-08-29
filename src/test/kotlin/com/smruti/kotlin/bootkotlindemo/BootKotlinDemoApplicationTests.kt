package com.smruti.kotlin.bootkotlindemo

import com.smruti.kotlin.bootkotlindemo.flux.Handler
import com.smruti.kotlin.bootkotlindemo.flux.Router
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest
class BootKotlinDemoApplicationTests {

    @Test
    fun contextLoads() {
        val client = WebTestClient.bindToRouterFunction(Router(Handler()).route()).build()
        client.get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus()
                .isOk
                .expectBodyList(String::class.java)
                .consumeWith<WebTestClient.ListBodySpec<String>> {
                    item ->
                    Assert.assertEquals("Hello, Spring!", item.responseBody!!.get(0))
                }

        Operators().runTest()

    }
}

