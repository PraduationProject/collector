package com.cake.dao;

import com.cake.entity.SensorAlarm;

import java.util.List;

/**
 * Created by xiaoyiyun on 2018/5/16.
 */
public interface SensorAlarmDao {
    public void insertSensor(SensorAlarm sa) throws Exception;

    public List<SensorAlarm> loadAllAlarm() throws Exception;
}
