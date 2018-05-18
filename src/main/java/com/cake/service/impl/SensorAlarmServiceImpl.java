package com.cake.service.impl;

import com.alibaba.fastjson.JSON;
import com.cake.dao.SensorAlarmDao;
import com.cake.dto.SensorBH1750Temp;
import com.cake.dto.SensorBMP180Temp;
import com.cake.dto.SensorDHT11Temp;
import com.cake.entity.SensorAlarm;
import com.cake.service.SensorAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by xiaoyiyun on 2018/5/16.
 */
@Service
public class SensorAlarmServiceImpl implements SensorAlarmService {

    @Autowired
    private SensorAlarmDao sensorAlarmDao;

    @Autowired
    private ShardedJedisPool jedisPool;

    public void insertDHT11(SensorDHT11Temp sd) throws Exception {
        sensorAlarmDao.insertSensor(new SensorAlarm(sd.NAME, sd.TE, sd.getTeUp(), sd.getTeDown(), sd.getStatus()));
        sensorAlarmDao.insertSensor(new SensorAlarm(sd.NAME, sd.HU, sd.getHuUp(), sd.getHuDown(), sd.getStatus()));
        ShardedJedis jedis = jedisPool.getResource();
        jedis.del("alarm");
    }

    public void insertBMP180(SensorBMP180Temp sb) throws Exception {
        sensorAlarmDao.insertSensor(new SensorAlarm(sb.NAME, sb.PR, sb.getPrUp(), sb.getPrDown(), sb.getStatus()));
        sensorAlarmDao.insertSensor(new SensorAlarm(sb.NAME, sb.TE, sb.getTeUp(), sb.getTeDown(), sb.getStatus()));
        sensorAlarmDao.insertSensor(new SensorAlarm(sb.NAME, sb.HI, sb.getHiUp(), sb.getHiDown(), sb.getStatus()));
        ShardedJedis jedis = jedisPool.getResource();
        jedis.del("alarm");
    }

    public void insertBH1750(SensorBH1750Temp sb) throws Exception {
        sensorAlarmDao.insertSensor(new SensorAlarm(sb.NAME, sb.LI, sb.getLiUp(), sb.getLiDown(), sb.getStatus()));
        ShardedJedis jedis = jedisPool.getResource();
        jedis.del("alarm");
    }

    public List<SensorAlarm> loadAllAlarm() throws Exception {
        ShardedJedis jedis = jedisPool.getResource();

        String listJson = jedis.get("alarm");
        List<SensorAlarm> alarmList = JSON.parseArray(listJson, SensorAlarm.class);

        if (alarmList == null) {
            alarmList = sensorAlarmDao.loadAllAlarm();
            listJson = JSON.toJSONString(alarmList, true);
            System.out.println(listJson);
            jedis.set("alarm", listJson);
        }

        return alarmList;
    }
}
