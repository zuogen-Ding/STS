package club.banyuan.project.dao;

public interface StudentDao {


    //注册

    void setStu();



    //考试，调用试题里的选题方法

    void test();

   //通过名查信息,返回

     boolean modifyPwd(String stuName,String newStuPwd);


}
