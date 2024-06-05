package com.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class EasyExcelUtil {
    private static Pattern sheetNamePattern = Pattern.compile("(31|30)|([21]\\d)|[1-9]");

    @Test
    public void test() {
//        System.out.println(sheetNamePattern.matcher("32").matches());
//        System.out.println(sheetNamePattern.matcher("31").matches());
//        System.out.println(sheetNamePattern.matcher("30").matches());
//        System.out.println(sheetNamePattern.matcher("28").matches());
//        System.out.println(sheetNamePattern.matcher("0").matches());
//        System.out.println(sheetNamePattern.matcher("1").matches());


        List<List<String>> headlist = Lists.newArrayList();
        headlist.add(Lists.newArrayList("name"));
        headlist.add(Lists.newArrayList("age"));
        headlist.add(Lists.newArrayList("address"));
        List<List<String>> datalist = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<String> data = Lists.newArrayList();
            data.add("name1");
            data.add("age2");
            data.add("adddress3");
            datalist.add(data);
        }
        EasyExcel.write("e:\\out.xlsx").head(headlist).sheet().doWrite(datalist);
    }

    public static void main(String[] args) {

        String excelFile = "C:\\Users\\liuguangming\\Desktop\\新版游站店2022年7月银员每日结算金额核对表 - 副本 (自动保存的)(1) - 副本.xlsm";
        String out="";

        // List list = new ArrayList();
        Map<String, MySheet> mySheetMap = new LinkedHashMap<>();
        //使用EasyExcel读取test1.xlsx文件
        EasyExcel.read(excelFile, new AnalysisEventListener<Map<Integer, String>>() {
                    //重写子类方法
                    @Override
                    public void invoke(Map<Integer, String> row, AnalysisContext analysisContext) {
                        String sheetName = analysisContext.readSheetHolder().getSheetName().trim();
                        if (!sheetNamePattern.matcher(sheetName).matches()) {
                            return;
                        }
                        MySheet mySheet = mySheetMap.get(sheetName);
                        if (mySheet == null) {
                            mySheet = new MySheet(sheetName);
                        }
                        mySheetMap.put(sheetName, mySheet);
                        Integer rowIndex = analysisContext.readRowHolder().getRowIndex();
                        if (rowIndex == 0) {
                            mySheet.setDate(row.get(8));
                        } else if (rowIndex == 2) {
                            mySheet.setValueMap(row);
                        } else if (rowIndex == 3) {
                            LinkedHashMap<Integer, String> newHeadMap = new LinkedHashMap<>();
                            for (Map.Entry<Integer, String> headEntry : row.entrySet()) {
                                newHeadMap.put(headEntry.getKey(), StringUtils.deleteWhitespace(headEntry.getValue()));
                            }
                            mySheet.setHeadMap(newHeadMap);
                        }
                    }

                    //重写子类方法
                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                    }

                    @Override
                    public void invokeHeadMap(Map headMap, AnalysisContext context) {
                        System.out.println(headMap);
                    }
                }
        ).headRowNumber(0).doReadAll();

        doSomething(mySheetMap);

        // export excel
        doExport(mySheetMap,out);

    }

    private static void doExport(Map<String, MySheet> mySheetMap,String out) {
        //all channel
        LinkedHashSet<String> headSet = new LinkedHashSet<>();
        headSet.add("日期");
        for (Map.Entry<String, MySheet> entry : mySheetMap.entrySet()) {
            MySheet mySheet = entry.getValue();
            headSet.addAll(mySheet.getHeadMap().values());
        }
        List<List<String>> headList = new ArrayList<>();
        for (String s : headSet) {
            headList.add(Lists.newArrayList(s));
        }
        List<List<String>> dataList = new ArrayList<>();

        for (Map.Entry<String, MySheet> entry : mySheetMap.entrySet()) {
            MySheet mySheet = entry.getValue();
            mySheet.getHeadValueMap().put("日期",mySheet.getDate());
            List<String> data = new ArrayList<>();
            for (String head : headSet) {
                data.add(mySheet.getHeadValueMap().get(head));
            }
            dataList.add(data);
        }

        EasyExcel.write(out).head(headList).sheet().doWrite(dataList);

    }


    private static void doSomething(Map<String, MySheet> mySheetMap) {
        outer:
        for (Map.Entry<String, MySheet> entry : mySheetMap.entrySet()) {
            //清理数据
            MySheet mySheet = entry.getValue();
            LinkedHashMap<Integer, String> newHeadMap = new LinkedHashMap<>();
            String start = "零钱";
            String over = "现金";
            String ignore = "预留";
            boolean flag = false;
            inner:
            for (Map.Entry<Integer, String> headEntry : mySheet.getHeadMap().entrySet()) {
                String headName = headEntry.getValue();
                if (start.equals(headName)) {
                    flag = true;
                    continue inner;
                }
                if (ignore.equals(headName)) {
                    continue inner;
                }
                if (over.equals(headName)) {
                    mySheet.setHeadMap(newHeadMap);
                    continue outer;
                }
                if (flag) {
                    newHeadMap.put(headEntry.getKey(), headEntry.getValue());
                }
            }
            //
        }
    }
}
