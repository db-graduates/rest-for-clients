package com.db.graduates.restforclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiffChartData {
    private List<ActualChartData> actualData;
    private List<PredictedChartData> predictedData;
}
