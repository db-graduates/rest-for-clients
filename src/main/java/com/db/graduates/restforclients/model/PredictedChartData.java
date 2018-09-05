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
public class PredictedChartData{
    @Id
    public String id;
    public Instant date;
    public long high;
    public long low;
    public long open;
    public long close;
    public long volume;
}
