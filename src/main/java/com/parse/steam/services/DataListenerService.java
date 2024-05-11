package com.parse.steam.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parse.steam.dtos.OutputItemDto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataListenerService {
    private final UpdateDBService updateDBService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenerData(String message) throws JsonProcessingException {
        updateDBService.insertToDB(objectMapper.readValue(message, OutputItemDto.class));
    }

}
