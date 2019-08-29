package com.smruti.kotlin.bootkotlindemo.configs.kafka

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaConfig {
    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress : String? = null;

    @Value(value = "\${kafka.topic.name}")
    private val topicName : String? = null;

    @Bean
    public fun kafkaAdmin() : KafkaAdmin{
        val configs : HashMap<String, Any> = hashMapOf("" to "")
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress.orEmpty());
        return KafkaAdmin(configs as Map<String, Any>);
    }

    @Bean
    public fun topic1() : NewTopic {
        return NewTopic(topicName.orEmpty(), 1, 1);
    }
}
