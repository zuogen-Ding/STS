package club.banyuan.project.dao.impl;

import club.banyuan.project.dao.StudentDao;
import club.banyuan.project.util.DruidUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDaoImpl implements StudentDao {


    static ResultSet resultSet=null;

    public static volatile StudentDaoImpl studentDaoImpl;
    private StudentDaoImpl(){}
    public static StudentDaoImpl getSocketReceive(){
        if(studentDaoImpl ==null){
            synchronized (StudentDaoImpl.class){
                if(studentDaoImpl ==null){
                    studentDaoImpl =new StudentDaoImpl();
                }

            }
        }
        return studentDaoImpl;
    }

    static String string=null;
    static PreparedStatement preparedStatement=null;

    @Override
    public void setStu(String stuName ,String stuPwd) {
        string="insert into student (s_name,s_password) values (?,?)";
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,stuName);
            preparedStatement.setString(2,stuPwd);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String commitInfo(String stuName) {
        string="select s_password from student where s_name=?";
        String str=null;
        try {
            preparedStatement=DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,stuName);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                str=resultSet.getString(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    @Override
    public  boolean modifyPwd(String stuName, String newStuPwd) {
        string="update student set  s_password=? where s_name=?";
        int i=0;
        try {
                preparedStatement= DruidUtil.getCon().prepareStatement(string);
                preparedStatement.setString(1,newStuPwd);
                preparedStatement.setString(2,stuName);
                i= preparedStatement.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }


        if(i==1)return true;
        return false;
    }
}
