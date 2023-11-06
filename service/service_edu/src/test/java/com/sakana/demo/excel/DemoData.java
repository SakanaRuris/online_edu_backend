package com.sakana.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author YU Chenxi
 * @since 2023/10/20 13:36
 */
@Data
public class DemoData {

    @ExcelProperty(value = "学生编号",index = 0)
    private Integer sno;
    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;
}
