package com.db.graduates.restforclients.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActualChartData {
    @Id
    private String id;
    private Instant date;
    private double high;
    private double low;
    private double open;
    private double close;
    private double volume;
    private double value;
}
