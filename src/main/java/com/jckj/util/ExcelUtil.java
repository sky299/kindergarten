package com.jckj.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtil {

    /**
     * 导入Excl文件
     *
     * @param xlsPath 文件路径
     * @param c       实体类
     * @return
     * @throws Exception
     */
    public static List<?> loadExcel(String xlsPath, Class<?> c) throws Exception {
        List<Object> list = new LinkedList<>();
        //创建文件流
        FileInputStream fil = new FileInputStream(xlsPath);
        //根据文件流导出Excel得到WorkBook对象
        Workbook wb = new HSSFWorkbook(fil);
        //获取Excel文档中的第一个表单
        Sheet sheet = wb.getSheetAt(0);

        //对行进行迭代
        for (Row r : sheet) {
            //判断是否是从第二行开始,因为第一行是表头
            if (r.getRowNum() < 1) {
                continue;
            }
            Row row = r.getCell(r.getRowNum() - 1).getRow();
            //实例化对象,每次循环都会初始化,不能放循环里
            Object obj = c.newInstance();
            //计数
            int j = 0;
            // FIXME 类型读取问题待修复
            for (Field field : c.getDeclaredFields()) {
                if (j < row.getPhysicalNumberOfCells()) {
                    field.setAccessible(true);
                    if (row.getCell(j).getCellType() == CellType.STRING) {
                        field.set(obj, row.getCell(j).getStringCellValue());
                        ++j;
                    } else if (row.getCell(j).getCellType() == CellType.NUMERIC) {
                        field.set(obj, (int) row.getCell(j).getNumericCellValue());
                        ++j;
                    }
                }
            }
            list.add(obj);
        }
        fil.close();
        return list;
    }


    /**
     * 导出Excel文件
     *
     * @param columns 表头
     * @param ts      实体类集合
     * @throws Exception
     */
    public static void writeExcel(String[] columns, List<?> ts) throws Exception {
        Workbook workbook = new HSSFWorkbook();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Sheet sheet = workbook.createSheet(ts.get(0).getClass().getSimpleName());

        Row row = sheet.createRow(0);
        //设置表头
        for (int i = 0; i < columns.length; i++) {
            row.createCell(i).setCellValue(columns[i]);
        }

        for (int i = 0; i < ts.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            Field[] fields = ts.get(i).getClass().getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                Cell cell = row1.createCell(j);
                Field field = fields[j];
                field.setAccessible(true);
                if (field.get(ts.get(i)) instanceof Number) {
                    if (field.get(ts.get(i)) instanceof Long) {
                        if (isDate((Long) field.get(ts.get(i)))){
                            cell.setCellValue(sf.format(new Date((Long) field.get(ts.get(i)))));
                        }else {
                            cell.setCellValue((Long) field.get(ts.get(i)));
                        }
                    } else if (field.get(ts.get(i)) instanceof Double) {
                        cell.setCellValue((Double) field.get(ts.get(i)));
                    } else {
                        cell.setCellValue((Integer) field.get(ts.get(i)));
                    }
                } else if (field.get(ts.get(i)) instanceof Date) {
                    cell.setCellValue(sf.format(new Date((Long) field.get(ts.get(i)))));
                } else {
                    cell.setCellValue((String) field.get(ts.get(i)));
                }
            }
        }
        FileOutputStream outputStream = new FileOutputStream("D:/" + ts.get(0).getClass().getSimpleName() + ".xls");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    private static boolean isDate(Long l){
        if (l.toString().length() == 13){
            return true;
        }
        return false;
    }
}
