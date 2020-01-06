package club.banyuan.project.service;


import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;


import java.io.File;
import java.util.List;
import java.util.Set;

public interface StudentService {

    //登陆
   boolean login(String stuName,String stuPws);

    //修改密码

    void modifyPwd(String stuName,String newPwd);

    //查询成绩
    Student getScore(String stuName);

    void input(int java,int databases,int python,String stuName);


    //注册

    void update(String stuName,String pwd);

    //考试
    Question exam(String queName);
}
