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
    private long high;
    private long low;
    private long open;
    private long close;
    private long volume;
    private long value;
}
