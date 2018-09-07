package com.db.graduates.restforclients.service;

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
public class KafkaListenerForPredictedDataTopic {

    @Autowired
    private PredictedChartDao predictedChartDao;

    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @KafkaListener(id="receiver2", topics = "pred", groupId = "${kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String str) {
        log.info("PRED Received Messasge in group foo: " + str);
        Message message = objectMapper.readValue(str, Message.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Instant date = LocalDateTime.parse(message.getDate(), formatter).toInstant(ZoneOffset.UTC);

        PredictedChartData chartData = PredictedChartData.builder()
                .high(message.getHigh())
                .low(message.getLow())
                .close(message.getClose())
                .open(message.getOpen())
                .date(date)
                .id(String.valueOf(message.getId()))
                .value(message.getValue())
                .volume(message.getVolume())
                .build();
        predictedChartDao.save(chartData);
    }
}
