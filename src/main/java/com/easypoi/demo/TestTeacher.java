package com.easypoi.demo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ExcelTarget("teacherEntity")
@Accessors(chain = true)
public class TestTeacher implements Serializable {
 
    private String id;
    /** name */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent",needMerge = true)
    private String name;
}
