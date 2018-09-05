package com.db.graduates.restforclients.dao;

import com.db.graduates.restforclients.model.ActualChartData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;

public interface ActualChartDao extends MongoRepository<ActualChartData, String> {
    List<ActualChartData> findByDateBetween(Instant dateFrom, Instant dateTo);

}
