package com.db.graduates.restforclients.service;

import com.db.graduates.restforclients.model.DiffChartData;

import java.time.Instant;

public interface ChartService {
    DiffChartData getActualAndPredictDataByDate(Instant dateFrom, Instant dateTo);
}
