package com.cake.service;

import com.cake.dto.SensorBH1750Temp;
import com.cake.dto.SensorBMP180Temp;
import com.cake.dto.SensorDHT11Temp;
import com.cake.entity.SensorAlarm;

import java.util.List;

/**
 * Created by xiaoyiyun on 2018/5/16.
 */
public interface SensorAlarmService {
    public void insertDHT11(SensorDHT11Temp sd) throws Exception;
    public void insertBMP180(SensorBMP180Temp sb) throws Exception;
    public void insertBH1750(SensorBH1750Temp sb) throws Exception;

    public List<SensorAlarm> loadAllAlarm() throws Exception;
}
