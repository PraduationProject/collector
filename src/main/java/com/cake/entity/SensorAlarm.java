package com.cake.entity;

import java.sql.Timestamp;

/**
 * Created by xiaoyiyun on 2018/5/16.
 */
public class SensorAlarm {

    private String sensor_name;
    private String type;
    private float up;
    private float down;
    private java.sql.Timestamp create_time;
    private java.sql.Timestamp modify_time;
    private int status;

    public SensorAlarm(String sensorName, String type, float up, float down, int status) {
        this.sensor_name = sensorName;
        this.type = type;
        this.up = up;
        this.down = down;
        this.create_time = new Timestamp(System.currentTimeMillis());
        this.modify_time = create_time;
        this.status = status;
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

    public float getUp() {
        return up;
    }

    public void setUp(float up) {
        this.up = up;
    }

    public float getDown() {
        return down;
    }

    public void setDown(float down) {
        this.down = down;
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
        return "SensorAlarm{" +
                "sensor_name='" + sensor_name + '\'' +
                ", type='" + type + '\'' +
                ", up=" + up +
                ", down=" + down +
                ", create_time=" + create_time +
                ", modify_time=" + modify_time +
                ", status=" + status +
                '}';
    }
}
