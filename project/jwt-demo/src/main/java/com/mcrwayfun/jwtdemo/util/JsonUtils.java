package com.mcrwayfun.jwtdemo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/9/29
 */
public class JsonUtils {

    public static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static String objectToJson(Object obj) throws Exception {
        String json = mapper.writeValueAsString(obj);
        return json;
    }


    public static String genInfoJsonStr(boolean success, String extInfo) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", success);
        map.put("msg", extInfo);
        String reJson = "";
        try {
            reJson = JsonUtils.objectToJson(map);
        } catch (Exception e) {
            logger.error("JsonUtils genInfoJsonStr 对象json转换异常: " + map);
        }
        return reJson;
    }

    public static String genInfoJsonStr(boolean success, String extInfo, Object dataArea) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", success);
        map.put("msg", extInfo);
        map.put("data", dataArea);
        String reJson = "";
        try {
            reJson = JsonUtils.objectToJson(map);
        } catch (Exception e) {
            logger.error("ClientResUtil getResponseToClient 对象json转换异常: " + map);
        }
        return reJson;
    }

    public static String genInfoJsonStr(boolean success, Object dataArea) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", success);
        map.put("data", dataArea);
        String reJson = "";
        try {
            reJson = JsonUtils.objectToJson(map);
        } catch (Exception e) {
            logger.error("ClientResUtil getResponseToClient 对象json转换异常: " + map);
        }
        return reJson;
    }

    public static String genInfoJsonStr(Integer code, String extInfo) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("code", code);
        map.put("msg", extInfo);
        String reJson = "";
        try {
            reJson = JsonUtils.objectToJson(map);
        } catch (Exception e) {
            logger.error("JsonUtils genInfoJsonStr 对象json转换异常: " + map);
        }
        return reJson;
    }

    public static String genInfoJsonStr(Integer code, String extInfo, Object dataArea) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", code);
        map.put("msg", extInfo);
        map.put("data", dataArea);
        String reJson = "";
        try {
            reJson = JsonUtils.objectToJson(map);
        } catch (Exception e) {
            logger.error("ClientResUtil getResponseToClient 对象json转换异常: " + map);
        }
        return reJson;
    }
}
