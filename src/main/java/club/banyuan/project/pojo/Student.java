package club.banyuan.project.pojo;

import java.io.*;

public class Student implements Serializable {
    //学号
    private int stuNum;
    //姓名
    private String stuName;
    //密码
    private String stuPassword;
    //成绩
    private int python=0;
    private int java=0;
    private int database=0;
    //总分
    private int stuTotalScore;
    //平均分
    private double stuAvgScore;

    public Student(String stuName, String stuPassword) {
        this.stuName = stuName;
        this.stuPassword = stuPassword;
    }

    public Student(int stuNum, String stuName) {
        this.stuNum = stuNum;
        this.stuName = stuName;
    }



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
                ", python=" + python +
                ", java=" + java +
                ", database=" + database +
                ", stuTotalScore=" + stuTotalScore +
                ", stuAvgScore=" + stuAvgScore +
                '}';
    }

}
