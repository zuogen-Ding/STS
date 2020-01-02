package club.banyuan.project.dao.impl;

import club.banyuan.project.dao.AdminDao;
import club.banyuan.project.pojo.Student;
import club.banyuan.project.util.DruidUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminDaoImpl implements AdminDao{
    static String string=null;
    static PreparedStatement preparedStatement=null;
    static ResultSet resultSet=null;

    public static volatile AdminDaoImpl AdminDaoImpl;
    private AdminDaoImpl(){}
    public static AdminDaoImpl getSocketReceive(){
        if(AdminDaoImpl ==null){
            synchronized (StudentDaoImpl.class){
                if(AdminDaoImpl ==null){
                    AdminDaoImpl =new AdminDaoImpl();
                }

            }
        }
        return AdminDaoImpl;
    }

    @Override
    public void setAdmin(String admName, String admPassword) {
        string="insert into student_service (service_name,service_pwd) values (?,?)";

        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,admName);
            preparedStatement.setString(2,admPassword);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStu(int stuNum, String stuName) {
        string="insert into student (s_num,s_name) values (?,?)";
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setInt(1,stuNum);
            preparedStatement.setString(2,stuName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delStu(int stuNum) {
        string="delete from student where s_num= ?";
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setInt(1,stuNum);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStu(int stuNum,String stuName) {
        string="update student set s_name =? where s_num=?";
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,stuName);
            preparedStatement.setInt(1,stuNum);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student selStu(int stuNum) {
        string="select * from student where s_num=?";
        Student student=null;
        try {
            preparedStatement=DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setInt(1,stuNum);
            resultSet =preparedStatement.executeQuery();
         if(resultSet.next()){
             student.setStuNum(resultSet.getInt(2));
             student.setStuName(resultSet.getString(3));
             student.setJava(resultSet.getInt(5));
             student.setDatabase(resultSet.getInt(6));
             student.setPython(resultSet.getInt(7));
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
