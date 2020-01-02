package club.banyuan.project.dao;

import club.banyuan.project.pojo.Student;

public interface AdminDao {


    //注册

    void setAdmin(String admName, String admPassword);

    //增加考试学员

    void addStu(int stuNum, String stuName);

    //删除考生,学号

    void delStu(int stuNum);

    //修改考生信息，学号

    void  updateStu(int  stuNum,String stuName);

    //查询考生，学号

    Student selStu(int stuNum);
}
