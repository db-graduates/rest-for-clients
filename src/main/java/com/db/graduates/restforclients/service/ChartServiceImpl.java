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
import java.util.Random;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MINUTES;

@Service
@RequiredArgsConstructor
public class ChartServiceImpl implements ChartService {

    private final ActualChartDao actualChartDao;
    private final PredictedChartDao predictedChartDao;

    @PostConstruct
    public void init(){
//        Instant date = Instant.now().plus(1, DAYS);
//        ActualChartData aChartData;
//        PredictedChartData pChartData;
//        Instant newDate = date;
//        long open, close, low, high, volume, value;
//
//        for (int i = 0; i < 200; i++) {
//            newDate = newDate.plus(5, MINUTES);
//            open = Math.round( Math.random() * ( 30 ) + 100 );
//            close = open + Math.round( Math.random() * ( 15 ) - Math.random() * 10 );
//            if ( open < close ) {
//                low = open - Math.round( Math.random() * 5 );
//                high = close + Math.round( Math.random() * 5 );
//            } else {
//                low = close - Math.round( Math.random() * 5 );
//                high = open + Math.round( Math.random() * 5 );
//            }
//
//           volume = Math.round( Math.random() * ( 1000 + i ) ) + 100 + i;
//           value = Math.round( Math.random() * ( 30 ) + 100 );
//
//            pChartData = PredictedChartData.builder()
//                    .high(high)
//                    .low(low)
//                    .open(open)
//                    .close(close)
//                    .volume(volume)
//                    .value(value)
//                    .date(newDate)
//                    .build();
//            aChartData = ActualChartData.builder()
//                    .high(high)
//                    .low(low)
//                    .open(open)
//                    .close(close)
//                    .volume(volume)
//                    .value(value)
//                    .date(newDate)
//                    .build();
//
//            predictedChartDao.save(pChartData);
//            actualChartDao.save(aChartData);
//        }
    }

    @Override
    public DiffChartData getActualAndPredictDataByDate(Instant dateFrom, Instant dateTo) {
        List<ActualChartData> actualData = actualChartDao.findByDateBetween(dateFrom, dateTo);
        List<PredictedChartData> predictedData = predictedChartDao.findByDateBetween(dateFrom, dateTo);
        return new DiffChartData(actualData, predictedData);
    }
}
