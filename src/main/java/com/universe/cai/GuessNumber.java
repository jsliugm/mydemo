package com.universe.cai;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

public class GuessNumber {
    private static List<Record> dataSource1() {
        return null;
    }

    private static List<Record> dataSource2() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        //ClassPathResource classPathResource = new ClassPathResource("/cai/1.xlsx");
        // List<Record> list = EasyExcelFactory.read(classPathResource.getInputStream()).doReadAllSync();
        //EasyExcel.read(classPathResource.getFile(), Record.class, new IndexOrNameDataListener()).sheet().doRead();
        // System.out.println(list);
        System.out.printf("[%d]",123);

    }

    static class IndexOrNameDataListener extends AnalysisEventListener<Record> {

        @Override
        public void invoke(Record data, AnalysisContext context) {
            System.out.println(data);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {

        }
    }
}

