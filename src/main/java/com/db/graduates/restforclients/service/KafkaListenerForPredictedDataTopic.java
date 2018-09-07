package com.db.graduates.restforclients.service;

import com.db.graduates.restforclients.dao.PredictedChartDao;
import com.db.graduates.restforclients.model.PredictedChartData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
//@Service
public class KafkaListenerForPredictedDataTopic implements KafkaListenerForTopic {

    @Autowired
    private PredictedChartDao predictedChartDao;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @SneakyThrows
    @KafkaListener(topics = "pred", groupId = "client")
    public void listen(String message) {
        log.info("PRED Received Messasge in group foo: " + message);
        PredictedChartData chartData = objectMapper.readValue(message, PredictedChartData.class);
        predictedChartDao.save(chartData);
    }
}
