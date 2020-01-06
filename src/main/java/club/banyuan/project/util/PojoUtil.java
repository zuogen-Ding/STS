package club.banyuan.project.util;

import club.banyuan.project.dao.QuestionDao;
import club.banyuan.project.pojo.Admin;
import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;

public class PojoUtil {
    private static Student student = new Student();
    private static Admin admin = new Admin();
   /* public static volatile PojoUtil pojoUtil;
    public static PojoUtil getPojoUtil(){
        if(pojoUtil ==null) {
            synchronized (PojoUtil.class) {
                if(pojoUtil ==null){
                    pojoUtil =new PojoUtil();
                }
            }
        }
        return pojoUtil;
    }*/

   private static Question question=new Question();

    public static Question getQuestion() {
        return question;
    }

    public static void setQuestion(Question question) {
        PojoUtil.question = question;
    }

    public static void setStudent(Student student) {
        PojoUtil.student = student;
    }

    public static String getTestName() {
        return question.getQueName();
    }

    public static void setTestName(String testName) {
        question.setQueName(testName);
    }

    public static Student getStudent() {
        return student;
    }

    public static Admin getAdmin() {
        return admin;
    }
}
