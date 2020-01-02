package club.banyuan.project.dao;

public interface StudentDao {


    //注册

    void setStu(String stuName,String stuPwd);


    //登陆

    String commitInfo(String stuName);




   //通过名查信息,返回

      boolean modifyPwd(String stuName,String newStuPwd);


}
