package com.cake.service.impl;

import com.alibaba.fastjson.JSON;
import com.cake.dao.SensorAlarmDao;
import com.cake.dao.SensorDataDao;
import com.cake.dto.SensorDataTemp;
import com.cake.entity.SensorAlarm;
import com.cake.entity.SensorData;
import com.cake.service.SensorAlarmService;
import com.cake.service.SensorDataService;
import com.cake.service.SensorInfoService;
import com.cake.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/4
 * Time:22:39
 * Email:971661949@qq.com
 */

//[
//    {
//        "sensorName":"sensor1",
//        "dataMap": {
//        "re": 1,
//        "sl": 1
//        }
//    },{
//        "sensorID":"sensor1",
//        "dataMap": {
//        "re": 1,
//        "sl": 1
//        }
//    }
//]

@Service
public class SensorDataServiceImpl implements SensorDataService {

    @Autowired
    SensorDataDao sensorDataDao;

    @Autowired
    SensorAlarmService sensorAlarmService;

    @Autowired
    SensorInfoService sensorInfoService;

    @Autowired
    private ShardedJedisPool jedisPool;

    @Transactional
    public int saveData(String data) throws Exception {

        List<SensorAlarm> alarmList = sensorAlarmService.loadAllAlarm();
        Map<String, SensorData> dataMap = new HashMap<String, SensorData>();
        ShardedJedis jedis = jedisPool.getResource();

        int insertCount = 1;
        List<SensorDataTemp> tempArry = JSON.parseArray(data, SensorDataTemp.class);
        for (SensorDataTemp d : tempArry) {
            for (Map.Entry<String, String> e : d.dataMap.entrySet()) {
                SensorData temp = new SensorData(d.sensorName, e.getKey(), new Double(e.getValue()));
                insertCount *= sensorDataDao.saveSensorData(temp);
                dataMap.put(temp.getSensor_name() + temp.getType(), temp);
            }
        }

        for (SensorAlarm s : alarmList) {
            double value = dataMap.get(s.getSensor_name() + s.getType()).getValue();
            if (value > s.getDown() && value < s.getUp()) {
                continue;
            }
            String phone = sensorInfoService.loadPhone(s.getSensor_name());
            String lock = jedis.get("already_" + s.getSensor_name() + "_" + s.getType() + "_" + phone);
            if (lock == null) {
                SmsUtil.SendMessage(phone, s.getSensor_name(), s.getType());
                jedis.set("already_" + phone, "lock");
                jedis.expire("already_" + phone, 60);
            }

        }
        jedis.close();
        return insertCount;
    }
}
