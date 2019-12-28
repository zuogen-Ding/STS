package club.banyuan.project.service;

import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;

import java.io.File;
import java.util.Set;

public interface StudentService {

    //修改密码

    void modifyPwd(String stuName,String newPwd);

    //查询成绩
    int getScore(Student stu);

    //注册

    void update();

    //考试
    File exam(Set<String> set);
}
