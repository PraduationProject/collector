package com.cake.service.impl;

import com.alibaba.fastjson.JSON;
import com.cake.dao.SensorDataDao;
import com.cake.dto.SensorDataTemp;
import com.cake.entity.SensorData;
import com.cake.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    public int saveData(String data) throws Exception {
        int insertCount = 1;
        List<SensorDataTemp> tempArry = JSON.parseArray(data, SensorDataTemp.class);
        for (SensorDataTemp d : tempArry) {
            for (Map.Entry<String, String> e : d.dataMap.entrySet()) {
                SensorData temp = new SensorData(d.sensorName, e.getKey(), new Double(e.getValue()));
                insertCount *= sensorDataDao.saveSensorData(temp);
            }
        }
        return insertCount;
    }
}
