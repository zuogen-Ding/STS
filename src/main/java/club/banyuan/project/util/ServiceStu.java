package club.banyuan.project.util;

public class ServiceStu {
    //学号
    private int stuNum;
    //姓名
    private String stuName;
    //密码
    private String stuPassword;
    //成绩
    private int python;
    private int java;
    private int database;

    private ServiceStu() {}
    public static volatile ServiceStu serviceStu;
    public static ServiceStu getServiceStu(){
        if(serviceStu ==null) {
            synchronized (PojoUtil.class) {
                if(serviceStu ==null){
                    serviceStu =new ServiceStu();
                }
            }
        }
        return serviceStu;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public int getPython() {
        return python;
    }

    public void setPython(int python) {
        this.python = python;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }
}
