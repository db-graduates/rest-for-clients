package com.db.graduates.restforclients.service;

import com.db.graduates.restforclients.dao.ActualChartDao;
import com.db.graduates.restforclients.dao.PredictedChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveToMongoKafkaConsumer {

    @Autowired
    private ActualChartDao actualChartDao;

    @Autowired
    private PredictedChartDao predictedChartDao;

    public void saveToRealDataCollection(String message) {
        System.out.println("Save to real data collection.");
    }

    public void saveToPredictedDataCollection(String message) {
        System.out.println("Save to predicted data collection.");
    }
}
