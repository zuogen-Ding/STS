package club.banyuan.project.service.impl;

import club.banyuan.project.dao.impl.AdminDaoImpl;
import club.banyuan.project.dao.impl.StudentDaoImpl;
import club.banyuan.project.pojo.Student;
import club.banyuan.project.service.AdminService;

public class AdminServiceImpl implements AdminService {
    public static volatile AdminServiceImpl adminServiceImpl;


    private AdminServiceImpl() {}

    public static AdminService getAdminServiceImpl(){
        if(adminServiceImpl ==null){
            synchronized (StudentDaoImpl.class){
                if(adminServiceImpl ==null){
                    adminServiceImpl =new AdminServiceImpl();
                }

            }
        }
        return adminServiceImpl;
    }

    @Override
    public void setAdmin(String admName, String admPassword) {
        AdminDaoImpl.getAdminDaoImpl().setAdmin(admName,admPassword);
    }

    @Override
    public void addStu(int stuNum, String stuName) {
        AdminDaoImpl.getAdminDaoImpl().addStu(stuNum,stuName);
    }

    @Override
    public void delStu(int stuNum) {
        AdminDaoImpl.getAdminDaoImpl().delStu(stuNum);
    }

    @Override
    public void updateStu(int stuNum, String stuName) {
        AdminDaoImpl.getAdminDaoImpl().updateStu(stuNum,stuName);
    }

    @Override
    public Student selStu(int stuNum) {
        return AdminDaoImpl.getAdminDaoImpl().selStu(stuNum);
    }

    @Override
    public boolean commit(String adminName, String adminPwd) {
        String s= AdminDaoImpl.getAdminDaoImpl().admLogin(adminName);
        return adminPwd.equals(s);
    }
}
