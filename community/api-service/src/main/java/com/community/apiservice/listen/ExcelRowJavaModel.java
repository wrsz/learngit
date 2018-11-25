package com.community.apiservice.listen;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: yanhan
 * @Date: 2018/11/21 17:11
 * @Description:
 */
@Data
public class ExcelRowJavaModel extends BaseRowModel {
    @ExcelProperty(index = 0,value = "银行放款编号")
    private int num;

    @ExcelProperty(index = 1,value = "code")
    private Long code;

    @ExcelProperty(index = 2,value = "测试1")
    private Double money;

    @ExcelProperty(index = 3,value = "测试2")
    private String times;

    @ExcelProperty(index = 4,value = "测试3")
    private int activityCode;

    @ExcelProperty(index = 5,value = "测试4")
    private Date date;

    @ExcelProperty(index = 6,value = "测试5")
    private Double lx;

    @ExcelProperty(index = 7,value = "测试6")

    private String name;
    @ExcelProperty(index = 8,value = "性别")
    private int sex;


}
