package com.mihee.board.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class EntityUtil {
    public static Map<String, String> MapFromObj (Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(obj);
            Gson gson = new Gson();
            Map<String, Object> originMap = gson.fromJson(str, Map.class);
            Map<String, String> newMap = new HashMap<String, String>();
            for (Map.Entry<String, Object> entry : originMap.entrySet()) {
                if (entry.getValue() != null) {
                    newMap.put(entry.getKey(), entry.getValue().toString());
                } else {
                    newMap.put(entry.getKey(), null);
                }
            }
            return newMap;
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
