package com.cake.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;


@Data
public class SensorData {
    private String sensor_name;
    private String type;
    private Double value;
    private long timestamp;
    private java.sql.Timestamp create_time;
    private java.sql.Timestamp modify_time;
    private int status;

    public SensorData() {
    }

    public SensorData(String sensor_name, String type, Double value) {
        this.sensor_name = sensor_name;
        this.type = type;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
        this.create_time = new Timestamp(this.timestamp);
        this.modify_time = create_time;
        this.status = 1;
    }
}
