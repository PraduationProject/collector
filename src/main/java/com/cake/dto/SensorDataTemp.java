package com.cake.dto;

import lombok.Data;

import java.util.Map;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/4
 * Time:23:52
 * Email:971661949@qq.com
 */

@Data
public class SensorDataTemp {
    public String sensorName;
    public Map<String, String> dataMap;

    @Override
    public String toString() {
        return "SensorDataTemp{" +
                "sensorName='" + sensorName + '\'' +
                ", dataMap=" + dataMap +
                '}';
    }
}


