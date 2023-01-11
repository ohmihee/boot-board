package com.mihee.board.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mihee.board.domain.Board;
import com.mihee.board.domain.vo.BoardContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityUtil {
    public static Map<String, Object> MapFromObj (Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(obj);
            //Gson gson = new Gson();
            Map<String, Object> originMap = mapper.readValue(str, Map.class);
            //Map<String, Object> originMap = gson.fromJson(str, Map.class);
            Map<String, Object> newMap = new HashMap<>();
            for (Map.Entry<String, Object> entry : originMap.entrySet()) {
                if (entry.getValue() != null ) {
                    newMap.put(entry.getKey(), entry.getValue());
                }
                else {
                    newMap.put(entry.getKey(), null);
                }
            }
            return newMap;
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Board board = new Board();

    }
}
