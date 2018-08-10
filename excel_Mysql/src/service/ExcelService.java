package service;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.DBUtil;
import entity.Tb_Student;
import jxl.Sheet;
import jxl.Workbook;


/** 
 * <p>Title: file_name</p> 
 * <p>Description: Service类 </p> 
 * <p>Copyright: Copyright (c) 2018</p> 
 * <p>Company: www.ZTESoft.com</p> 
 * @author @yrf 
 * @date 2018年8月10日 
 * @version 1.0 
 */

public class ExcelService {
	 
     //查询tb_student表中所有的数据
    public static List<Tb_Student> getAllByDb(){
        List<Tb_Student> list=new ArrayList<Tb_Student>();
        try {
            DBUtil db=new DBUtil();
            String sql="select * from tb_student";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                int age=rs.getInt("age");
                String register_date=rs.getString("register_date");
                list.add(new Tb_Student(id, name, sex, age,register_date));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    //查询指定目录中电子表格中所有的数据
     
    public static List<Tb_Student> getAllByExcel(String file){
        List<Tb_Student> list=new ArrayList<Tb_Student>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Test Shee 1");
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                	
                    //第一个是列数j，第二个是行数i
//                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String id = "0";
                    String name=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String age=rs.getCell(j++, i).getContents();
                    
                    Date date =new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
                    String register_date=sdf.format(date);
                    
                    
                    System.out.println("id:"+id+" name:"+name+" sex:"+sex+" age:"+age+" register_date:"+register_date);
                    list.add(new Tb_Student(Integer.parseInt(id), name, sex, Integer.parseInt(age),register_date));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     */
    public static boolean isExist(int id){
        try {
            DBUtil db=new DBUtil();
            ResultSet rs=db.Search("select * from tb_student where id=?", new String[]{id+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        /*List<StuEntity> all=getAllByDb();
        for (StuEntity stuEntity : all) {
            System.out.println(stuEntity.toString());
        }*/
        
        System.out.println(isExist(1));
        
    }
    
}
