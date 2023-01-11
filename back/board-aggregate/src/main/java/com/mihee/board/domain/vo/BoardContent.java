package com.mihee.board.domain.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mihee.board.domain.Board;
import com.mihee.board.util.EntityUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BoardContent {
    private int order;
    private String contentType;
    private String content;

//    public static void modifyValues(Object obj, Board board) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String json = objectMapper.writeValueAsString(obj);
//            List<BoardContent> boardContents = objectMapper.readValue(json, new TypeReference<List<BoardContent>>() {
//            });
//            for (BoardContent boardContent : boardContents) {
//                objectMapper.readValue(boarc)
//            }
//
////            for (Map.Entry<String, Object> entry: boardContents.entrySet()) {
////                System.out.println(entry.getKey()+":"+entry.getValue());
////
////            }
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        //System.out.println(new Gson().toJson(obj));
//        //String json = new Gson().toJson(obj);
//
//
////        Map<String, Object> originMap = new Gson().fromJson(obj.toString(), Map.class);
////        for (Map.Entry<String, Object> entry: originMap.entrySet()) {
////            System.out.println(entry.getValue());
////        }
//    }


//    public static void main(String[] args) throws JsonProcessingException {
//        String str = "[{\"order\":1.0,\"content\":\"testste\\u003d\\u003d\\u003d\"},{\"order\":2.0,\"content\":\"testste\\u003d\\u003d\\u003d\"}]\n";
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<BoardContent> boardContents = objectMapper.readValue(str, new TypeReference<List<BoardContent>>() {
//        });
//        System.out.println();
//
//    }


}
