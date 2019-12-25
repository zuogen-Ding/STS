package club.banyuan.project.dao;

public interface StudentDao {

    //退出
    void  close();

    //注册

    void setStu();

    //修改信息

    void update();

    //考试，调用试题里的选题方法

    void test();


}
