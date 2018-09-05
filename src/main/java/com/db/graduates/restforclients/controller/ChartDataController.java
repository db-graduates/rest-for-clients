package com.db.graduates.restforclients.controller;

import com.db.graduates.restforclients.model.DiffChartData;
import com.db.graduates.restforclients.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/chart-data")
public class ChartDataController {

    @Autowired
    private ChartService chartService;

    @GetMapping("/diff")
    public DiffChartData getDiffChartData(
            @RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo){
        return chartService.getActualAndPredictDataByDate(dateFrom.toInstant(ZoneOffset.UTC), dateTo.toInstant(ZoneOffset.UTC));
    }
}
