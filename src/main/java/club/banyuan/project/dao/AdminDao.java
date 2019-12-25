package club.banyuan.project.dao;

import club.banyuan.project.pojo.Student;

public interface AdminDao {
    //退出
    void  close();

    //注册

    void set();

    //增加考试学员

    void addStu(Student student);

    //删除考生,学号

    void delStu(int stuNum);

    //修改考生信息，学号

    void  updateStu(int stuNum);

    //查询考生，学号

    Student selStu(int stuNum);
}
