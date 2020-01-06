package club.banyuan.project.dao.impl;

import club.banyuan.project.dao.StudentDao;
import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;
import club.banyuan.project.util.DruidUtil;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    static File file=null;
    static ResultSet resultSet=null;
    static{
        file=new File("question.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static volatile StudentDaoImpl studentDaoImpl;
    private StudentDaoImpl(){}
    public static StudentDaoImpl getStudentDaoImpl(){
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
    public boolean commitInfo(String stuName,String stuPwd) {
        string="select s_password from student where s_name=?";
        String str=null;
        try {
            preparedStatement=DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,stuName);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                str=resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean f=stuPwd.equals(str);
        return f;
    }

    @Override
    public List<Question> exam(String queName) {
        return QuestionDaoImpl.getQuestionDaoImpl().selQues(queName);


    }

    @Override
    public Student getScore(String stuName) {
        Student student=new Student();
        string ="select * from student where s_name=?";
        int i;
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,stuName);

            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                student.setJava(resultSet.getInt(5));
                student.setPython(resultSet.getInt(9));
                student.setDatabase(resultSet.getInt(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
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

    @Override
    public void input(int java, int databases, int python,String stuName) {
        string="update student set java_grade=? , database_grade =? , Python_grade=? where s_name=?";
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setInt(1,java);
            preparedStatement.setInt(2,databases);
            preparedStatement.setInt(3,python);
            preparedStatement.setString(4,stuName);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
