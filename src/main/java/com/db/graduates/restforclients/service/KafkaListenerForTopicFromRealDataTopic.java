package com.db.graduates.restforclients.service;

import com.db.graduates.restforclients.dao.ActualChartDao;
import com.db.graduates.restforclients.dao.PredictedChartDao;
import com.db.graduates.restforclients.model.ActualChartData;
import com.db.graduates.restforclients.model.PredictedChartData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaListenerForTopicFromRealDataTopic implements KafkaListenerForTopic {

    @Autowired
    private ActualChartDao actualChartDao;

    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @KafkaListener(topics = "test", groupId = "client")
    public void listen(String message) {
        log.info("TEST Received Messasge in group foo: " + message);
        ActualChartData chartData = objectMapper.readValue(message, ActualChartData.class);
        actualChartDao.save(chartData);
    }
}
