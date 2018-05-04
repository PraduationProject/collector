package com.cake.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;


@Data
public class SensorData {
    private int id;
    private String sensor_id;
    private String type;
    private Double value;
    private java.sql.Timestamp create_time;
    private java.sql.Timestamp modify_time;
    private int status;

    public SensorData() {
    }

    public SensorData(String sensor_id, String type, Double value) {
        this.sensor_id = sensor_id;
        this.type = type;
        this.value = value;
        this.create_time = new Timestamp(System.currentTimeMillis());
        this.modify_time = create_time;
        this.status = 1;
    }
}
