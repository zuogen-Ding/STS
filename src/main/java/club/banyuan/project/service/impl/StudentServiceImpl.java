package club.banyuan.project.service.impl;



import club.banyuan.project.pojo.Student;
import club.banyuan.project.service.StudentService;

import java.io.File;
import java.util.Set;

public class StudentServiceImpl implements StudentService {

    //修改密码
    @Override
    public void modifyPwd(String stuName,String newPwd) {

    }

    @Override
    public int getScore(Student stu) {
        return 0;
    }

    @Override
    public void update() {

    }

    @Override
    public File exam(Set<String> set) {
        File file=null;
        return file;
    }
}
