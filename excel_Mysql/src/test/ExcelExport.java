package test;

import java.io.File;
import java.util.List;

import entity.Tb_Student;
import service.ExcelService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/** 
 * <p>Title: file_name</p> 
 * <p>Description: 导出Excel表 </p> 
 * <p>Copyright: Copyright (c) 2018</p> 
 * <p>Company: www.ZTESoft.com</p> 
 * @author @yrf 
 * @date 2018年8月10日 
 * @version 1.0 
 */
public class ExcelExport {

    public static void main(String[] args) {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "D://test//exceltest//Student.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<Tb_Student> list= ExcelService.getAllByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelId= new Label(0, 0, "编号(id)");//表示第
               Label labelName= new Label(1, 0, "姓名(name)");
               Label labelSex= new Label(2, 0, "性别(sex)");
               Label labelAge= new Label(3, 0, "年龄(age)");
               Label labelRegister_date= new Label(4, 0, "注册时间(register_date)");
               
               ws.addCell(labelId);
               ws.addCell(labelName);
               ws.addCell(labelSex);
               ws.addCell(labelAge);
               ws.addCell(labelRegister_date);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
                   Label labelName_i= new Label(1, i+1, list.get(i).getName());
                   Label labelSex_i= new Label(2, i+1, list.get(i).getSex());
                   Label labelAge_i= new Label(3, i+1, list.get(i).getAge()+"");
                   Label labelRegister_date_i= new Label(4, i+1, list.get(i).getRegister_date()+"");
                   ws.addCell(labelId_i);
                   ws.addCell(labelName_i);
                   ws.addCell(labelSex_i);
                   ws.addCell(labelAge_i);
                   ws.addCell(labelRegister_date_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
               System.out.println("导出Excel成功");
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
