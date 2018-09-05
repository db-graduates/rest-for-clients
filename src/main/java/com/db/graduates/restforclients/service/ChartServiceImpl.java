package com.db.graduates.restforclients.service;

import com.db.graduates.restforclients.dao.ActualChartDao;
import com.db.graduates.restforclients.dao.PredictedChartDao;
import com.db.graduates.restforclients.model.ActualChartData;
import com.db.graduates.restforclients.model.DiffChartData;
import com.db.graduates.restforclients.model.PredictedChartData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChartServiceImpl implements ChartService {

    private final ActualChartDao actualChartDao;
    private final PredictedChartDao predictedChartDao;

    @PostConstruct
    public void init(){
        PredictedChartData chartData = PredictedChartData.builder()
                .high(1)
                .low(2)
                .date(Instant.now())
                .build();
        predictedChartDao.save(chartData);
    }

    @Override
    public DiffChartData getActualAndPredictDataByDate(Instant dateFrom, Instant dateTo) {
        List<ActualChartData> actualData = actualChartDao.findByDateBetween(dateFrom, dateTo);
        List<PredictedChartData> predictedData = predictedChartDao.findByDateBetween(dateFrom, dateTo);
        return new DiffChartData(actualData, predictedData);
    }

    public static void main(String[] args) {
        System.out.println(Instant.now());
    }

}
