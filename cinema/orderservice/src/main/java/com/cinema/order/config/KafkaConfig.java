package com.cinema.order.config;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.services.OrderManageService;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.StreamJoined;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.Duration;

@Configuration
public class KafkaConfig {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConfig.class);

    @Autowired
    OrderManageService orderManageService;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic.payment-order}")
    private String paymentOrder;

    @Value("${spring.kafka.topic.stock}")
    private String stockTopic;

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(topicName)
                .build();
    }

    @Bean
    public NewTopic paymentOrderTopic() {
        return TopicBuilder
                .name(paymentOrder)
                .build();
    }

    @Bean
    public NewTopic stockTopic() {
        return TopicBuilder
                .name(stockTopic)
                .build();
    }

}
