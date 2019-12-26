package club.banyuan.project.service;

import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;

public interface StudentService {

    //修改密码

    void modifyPwd();

    //查询成绩
    int getScore(Student stu);

    //注册

    void update();

    //考试
    Question exam();
}
