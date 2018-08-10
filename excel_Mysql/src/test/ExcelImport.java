package test;


import java.util.List;

import service.ExcelService;
import utils.DBUtil;
import entity.Tb_Student;

/** 
 * <p>Title: file_name</p> 
 * <p>Description: 导入Excel表</p> 
 * <p>Copyright: Copyright (c) 2018</p> 
 * <p>Company: www.ZTESoft.com</p> 
 * @author @yrf 
 * @date 2018年8月10日 
 * @version 1.0 
 */
public class ExcelImport {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<Tb_Student> listExcel=ExcelService.getAllByExcel("D://test//exceltest//Student2.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/
        
        DBUtil db=new DBUtil();
        
        for (Tb_Student list : listExcel) {
            int id=list.getId();
            System.out.println("id"+id);
            if (!ExcelService.isExist(id)) {
                //不存在就添加
                String sql="insert into tb_student (name,sex,age,register_date) values(?,?,?,?)";
                String[] str=new String[]{list.getName(),list.getSex(),list.getAge()+"",list.getRegister_date()};
                db.AddU(sql, str);
            }else {
                //存在就更新
                String sql="update tb_student set name=?,sex=?,num=? where id=?";
                String[] str=new String[]{list.getName(),list.getSex(),list.getAge()+"",list.getRegister_date(),id+""};
                db.AddU(sql, str);
            }
            System.out.println("数据导入成功");
        }
    }
}
