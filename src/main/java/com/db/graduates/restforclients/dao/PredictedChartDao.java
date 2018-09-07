package com.db.graduates.restforclients.dao;

import com.db.graduates.restforclients.model.PredictedChartData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;

public interface PredictedChartDao extends MongoRepository<PredictedChartData, String> {
    List<PredictedChartData> findByDateBetween(Instant dateFrom, Instant dateTo);
}
