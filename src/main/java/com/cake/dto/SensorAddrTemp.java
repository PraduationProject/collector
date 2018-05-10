package com.cake.dto;

import lombok.Data;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/10
 * Time:13:56
 * Email:971661949@qq.com
 */
@Data
public class SensorAddrTemp {
    String sensor_name;
    String sensor_addr;

    @Override
    public String toString() {
        return "SensorAddrTemp{" +
                "sensor_name='" + sensor_name + '\'' +
                ", sensor_addr='" + sensor_addr + '\'' +
                '}';
    }
}
