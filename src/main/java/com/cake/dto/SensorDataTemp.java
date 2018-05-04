package com.cake.dto;

import java.util.Map;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/4
 * Time:23:52
 * Email:971661949@qq.com
 */
public class SensorDataTemp {
    public String sensorID;
    public Map<String, String> dataMap;

    @Override
    public String toString() {
        return "SensorDataTemp{" +
                "sensorID='" + sensorID + '\'' +
                ", dataMap=" + dataMap +
                '}';
    }
}


