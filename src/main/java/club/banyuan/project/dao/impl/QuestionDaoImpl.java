package club.banyuan.project.dao.impl;

import club.banyuan.project.dao.QuestionDao;
import club.banyuan.project.pojo.Question;
import club.banyuan.project.util.DruidUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class QuestionDaoImpl implements QuestionDao {
    static PreparedStatement preparedStatement=null;
    static ResultSet resultSet=null;
    static Set<Question> set=new HashSet<>();
    static  List<Question> list = new ArrayList<>();
    static int count=0;


    public static volatile QuestionDaoImpl questionDaoImpl;
    private QuestionDaoImpl(){}
    public static QuestionDaoImpl getQuestionDaoImpl(){
        if(questionDaoImpl ==null){
            synchronized (StudentDaoImpl.class){
                if(questionDaoImpl ==null){
                    questionDaoImpl =new QuestionDaoImpl();
                }

            }
        }
        return questionDaoImpl;
    }

    @Override
    public List<Question> selQues(String queName) {
        count++;
        String string="select * from QueNum where QueNum_name =?";
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,queName);
            resultSet=preparedStatement.executeQuery();


            while (resultSet.next()){
                Question   question=new Question();
                question.setQueTitle(resultSet.getString(3));
                question.setOptionA("\nA."+resultSet.getString(4));
                question.setOptionB("\nB."+resultSet.getString(5));
                question.setOptionC("\nC."+resultSet.getString(6));
                question.setOptionD("\nD."+resultSet.getString(7));
                question.setQueAnswer("\n"+resultSet.getString(8));

                set.add(question);
            }
            Object[] objects =set.toArray();
            for (Object o :objects) {
                Question question1=(Question)o;
                list.add(question1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
