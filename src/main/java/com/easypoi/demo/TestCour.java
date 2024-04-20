package com.easypoi.demo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@ExcelTarget("courseEntity")
@Accessors(chain = true)
public class TestCour implements Serializable {
 
    /** 主键 */
    private String        id;
    /** 课程名称 */
    @Excel(name = "课程名称", orderNum = "1", width = 25,needMerge = true)
    private String        name;
    /** 老师主键 */
    @ExcelEntity(id = "absent")
    private TestTeacher mathTeacher;
 
    @ExcelCollection(name = "学生", orderNum = "4")
    private List<TestStudent> students;
}
