package com.universe.cai;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
//@AllArgsConstructor
public class Record {
    @ExcelProperty("id")
    private Integer id;
    @ExcelProperty("createDate")
    private Date createDate;
}
