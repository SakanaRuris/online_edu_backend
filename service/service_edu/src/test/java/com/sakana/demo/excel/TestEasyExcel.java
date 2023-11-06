package com.sakana.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YU Chenxi
 * @since 2023/10/20 13:37
 */
public class TestEasyExcel {
    public static void main(String[] args) {
        String filename = "C:\\guli_log\\write.xlsx";
        EasyExcel.read(filename,DemoData.class,new ExcelListener()).sheet().doRead();
        //EasyExcel.write(filename,DemoData.class).sheet("学生列表").doWrite(getData());
    }

    private  static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for(int i = 0; i<10;i++){
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("aa"+i);
            list.add(data);
        }
        return list;
    }

}
