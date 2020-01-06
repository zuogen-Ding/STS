package club.banyuan.project.service.impl;




import club.banyuan.project.dao.impl.StudentDaoImpl;
import club.banyuan.project.pojo.Question;
import club.banyuan.project.pojo.Student;
import club.banyuan.project.service.StudentService;

import java.util.*;


public class StudentServiceImpl implements StudentService {
    public static volatile StudentServiceImpl studentService;

    static Question question=new Question();
    static int flag=0;
    static int[] arr=new int[3];
    static {
        Set<Integer> set=new LinkedHashSet<>();

        int count=0;

        Random random=new Random();
        while (set.size()<3){
            Integer i=random.nextInt(3);
            set.add(i);
        }
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            int j = (int) iterator.next();
            arr[count] = j;
            count++;
        }
    }
    private StudentServiceImpl() {}

    public static StudentServiceImpl getStudentService(){
        if(studentService ==null){
            synchronized (StudentDaoImpl.class){
                if(studentService ==null){
                    studentService =new StudentServiceImpl();
                }

            }
        }
        return studentService;
    }

    @Override
    public boolean login(String stuName, String stuPwd) {
        return StudentDaoImpl.getStudentDaoImpl().commitInfo(stuName,stuPwd);
    }

    //修改密码
    @Override
    public void modifyPwd(String stuName,String newPwd) {
        StudentDaoImpl.getStudentDaoImpl().modifyPwd(stuName,newPwd);
    }

    @Override
    public Student getScore(String stuName) {
        return StudentDaoImpl.getStudentDaoImpl().getScore(stuName);
    }

    @Override
    public void input(int java, int databases, int python,String stuName) {
    StudentDaoImpl.getStudentDaoImpl().input(java,databases,python,stuName);
    }

    @Override
    public void update(String stuName, String pwd) {
        StudentDaoImpl.getStudentDaoImpl().setStu(stuName,pwd);
    }

    @Override
    public Question exam(String queName) {
       List<Question> list= StudentDaoImpl.getStudentDaoImpl().exam(queName);
        while (flag>2)flag=0;
        flag++;
        return list.get(arr[flag-1]);

    }


}
