package club.banyuan.project.pojo;

public class Student {
    //学号
    private int stuNum;
    //姓名
    private String stuName;
    //密码
    private String stuPassword;
    //专业
    private String major;
    //成绩
    private int python;
    private int java;
    private int database;
    //总分
    private int stuTotalScore;
    //平均分
    private double stuAvgScore;

    public Student() {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public int getStuTotalScore() {
        return stuTotalScore;
    }

    public void setStuTotalScore(int stuTotalScore) {
        this.stuTotalScore = stuTotalScore;
    }

    public double getStuAvgScore() {
        return stuAvgScore;
    }

    public void setStuAvgScore(double stuAvgScore) {
        this.stuAvgScore = stuAvgScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum=" + stuNum +
                ", stuName='" + stuName + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", major='" + major + '\'' +
                ", python=" + python +
                ", java=" + java +
                ", database=" + database +
                ", stuTotalScore=" + stuTotalScore +
                ", stuAvgScore=" + stuAvgScore +
                '}';
    }
}
