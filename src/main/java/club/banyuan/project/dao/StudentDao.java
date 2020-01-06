package club.banyuan.project.dao;

import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;

import java.io.File;
import java.util.List;

public interface StudentDao {


    //注册


    void setStu(String stuName,String stuPwd);


    //登陆

    boolean commitInfo(String stuName ,String stuPwd);

    //考试
    List<Question> exam(String className);



   //通过名查信息
    Student getScore(String stuName);

    //修改密码

    boolean modifyPwd(String stuName,String newStuPwd);


    //录入成绩
    void input(int java,int databases,int python,String stuName);

}
