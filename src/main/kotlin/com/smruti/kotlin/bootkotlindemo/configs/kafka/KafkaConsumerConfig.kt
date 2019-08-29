package com.smruti.kotlin.bootkotlindemo.configs.kafka

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.HashMap
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.KafkaListener



@EnableKafka
@Configuration
class KafkaConsumerConfig {
    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress : String? = null

    @Value(value = "\${kafka.groupId}")
    private val groupId : String? = null;

    var consumedMsg : ArrayList<String> = arrayListOf()

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val props = HashMap<String, Any>()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress.orEmpty()
        props[ConsumerConfig.GROUP_ID_CONFIG] = groupId.orEmpty()
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.setConsumerFactory(consumerFactory())
        //factory.setRecordFilterStrategy { record -> record.value().contains("World") }
        return factory
    }

    @KafkaListener(topics = arrayOf("test"), containerFactory = "kafkaListenerContainerFactory")
    fun listen(message: String) {
        consumedMsg.add(message)
    }
}