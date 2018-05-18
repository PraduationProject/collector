package com.cake.util;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.cake.util.HttpUtil;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/18
 * Time:0:43
 * Email:971661949@qq.com
 */

//http://58.87.89.234:8001/sms?phone=18792421443&system=343&time=1&item=1123

public class SmsUtil {
    private static final String URL = "http://localhost:8001/sms";

    public static void SendMessage(String phone, String system, String item) throws Exception {
        Map<String, String> datamap = new HashMap<String, String>();
        datamap.put("phone", phone);
        datamap.put("system", system);
        datamap.put("time", URLEncoder.encode(new Timestamp(System.currentTimeMillis()).toString(), "UTF-8").substring(5, 18));
        datamap.put("item", item);
        HttpUtil.httpGet(URL, datamap);
    }
}
