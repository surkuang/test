package com.fpi.test.api;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class Test {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test",null);
            jsonObject.put("test01","test01");
            jsonObject.keySet().stream().forEach(System.out::println);
            System.out.println((Map<String,Object>)jsonObject.get("test"));
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.putAll(jsonObject);
    }
}
