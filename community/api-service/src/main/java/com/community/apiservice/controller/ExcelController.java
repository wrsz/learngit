package com.community.apiservice.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.community.apiservice.listen.*;
import com.core.util.back.CodeEnum;
import com.core.util.back.ResultJsonFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yanhan
 * @Date: 2018/11/21 13:44
 * @Description:
 */
@RestController
@RequestMapping("excel")
public class ExcelController {


    @PostMapping("easy")
    public ResultJsonFormat easy(@RequestParam(value = "webFile") MultipartFile webFile){
        ResultJsonFormat res=new ResultJsonFormat("访问成功");
        InputStream inputStream = null;
        long l1=System.currentTimeMillis();
        try {
            inputStream = webFile.getInputStream();
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1, ExcelRowJavaModel.class), listener);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.gc();
        }
        long l2=System.currentTimeMillis();
        System.out.println("导入10W:"+(l2-l1));
        return res;
    }

    @RequestMapping(value = "writeExcel", method = RequestMethod.GET)
    public void writeExcel(HttpServletResponse response) throws IOException {
        List<ExcelRowJavaModel> list = getData();
        String fileName = "一个 Excel 文件";
        String sheetName = "第一个sheet";

        ExcelUtil.writeExcel(response, list, fileName, sheetName, new ExcelRowJavaModel());
        System.gc();
    }

    public static List<ExcelRowJavaModel> getData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<ExcelRowJavaModel> datas = new ArrayList<ExcelRowJavaModel>();
        for (int i = 0; i <100000 ; i++) {
            ExcelRowJavaModel model = new ExcelRowJavaModel();
            model.setNum(1);
            model.setCode(1L);
            model.setMoney(1.0d);
            model.setTimes("1");
            model.setActivityCode(1);
            model.setDate(new Date());
            model.setLx(0.0);
            model.setName("测试111");
            model.setSex(1);
            datas.add(model);
        }
        return datas;
    }
}
