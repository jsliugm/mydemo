package com.easyexcel;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MySheet {
    private String sheetName;
    private String date;
    private Map<Integer, String> headMap;
    private Map<Integer, String> valueMap;
    private Map<String, String> headValueMap;

    public MySheet(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setHeadMap(Map<Integer, String> headMap) {
        this.headMap = headMap;
        //生成新的映射
        if (valueMap != null) {
            Map<String, String> hvMap = new HashMap<>();
            for (Map.Entry<Integer, String> headEntry : headMap.entrySet()) {
                Integer key = headEntry.getKey();
                String value = headEntry.getValue();
                hvMap.put(value, valueMap.get(key));
            }
            this.headValueMap = hvMap;
        }
    }
}
