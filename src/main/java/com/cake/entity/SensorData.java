package com.cake.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;


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

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getModify_time() {
        return modify_time;
    }

    public void setModify_time(Timestamp modify_time) {
        this.modify_time = modify_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "sensor_name='" + sensor_name + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                ", create_time=" + create_time +
                ", modify_time=" + modify_time +
                ", status=" + status +
                '}';
    }
}
