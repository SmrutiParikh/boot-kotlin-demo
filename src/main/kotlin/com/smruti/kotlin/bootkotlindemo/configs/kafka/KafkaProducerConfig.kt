package com.smruti.kotlin.bootkotlindemo.configs.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.HashMap
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.SendResult
import org.springframework.util.concurrent.ListenableFutureCallback

@Configuration
class KafkaProducerConfig() {
    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress : String? = null;

    @Value(value = "\${kafka.topic.name}")
    private val topicName : String? = null;

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val configProps = HashMap<String, Any>()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress.orEmpty()
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }

    fun sendMessage(message: String) {

        val future = kafkaTemplate().send(topicName.orEmpty(), message)

        future.addCallback(object : ListenableFutureCallback<SendResult<String, String>> {

            override fun onSuccess(result: SendResult<String, String>?) {
                println("Sent message=[" + message +
                        "] with offset=[" + result!!.recordMetadata.offset() + "]")
            }

            override fun onFailure(ex: Throwable) {
                println("Unable to send message=["
                        + message + "] due to : " + ex.message)
            }
        })
    }
}
