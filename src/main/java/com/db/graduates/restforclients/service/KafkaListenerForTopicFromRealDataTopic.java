package com.db.graduates.restforclients.service;

import com.db.graduates.restforclients.dao.ActualChartDao;
import com.db.graduates.restforclients.dao.PredictedChartDao;
import com.db.graduates.restforclients.model.ActualChartData;
import com.db.graduates.restforclients.model.PredictedChartData;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.com.model.Message;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Log4j2
@Service
public class KafkaListenerForTopicFromRealDataTopic {

    @Autowired
    private ActualChartDao actualChartDao;

    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @KafkaListener(id="receiver1", topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String str) {
        log.info("TEST Received Messasge in group foo: " + str);
        Message message = objectMapper.readValue(str, Message.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Instant date = LocalDateTime.parse(message.getDate(), formatter).toInstant(ZoneOffset.UTC);

        ActualChartData chartData = ActualChartData.builder()
                .high(message.getHigh())
                .low(message.getLow())
                .close(message.getClose())
                .open(message.getOpen())
                .date(date)
                .id(String.valueOf(message.getId()))
                .value(message.getValue())
                .volume(message.getVolume())
                .build();
        actualChartDao.save(chartData);
    }
}
