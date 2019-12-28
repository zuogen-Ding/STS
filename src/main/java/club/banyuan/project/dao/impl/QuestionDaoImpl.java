package club.banyuan.project.dao.impl;

import club.banyuan.project.dao.QuestionDao;
import club.banyuan.project.util.DruidUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class QuestionDaoImpl implements QuestionDao {
    static PreparedStatement preparedStatement=null;
    static ResultSet resultSet=null;
    static Set<String> set=new HashSet<String>();

    @Override
    public Set selQues(String queName) {
        //从数据库里选时就完成乱选
        String string="select *from QueNum where QueNum_name =? and q_id=?";
        try {
            preparedStatement= DruidUtil.getCon().prepareStatement(string);
            preparedStatement.setString(1,queName);
            preparedStatement.setInt(2,(int)(Math.random()*10)+1);
            resultSet=preparedStatement.executeQuery();

            //
            if(resultSet.next()&&set.size()<11){
                set.add(resultSet.getString(3)+"\nA."+resultSet.getString(4)+"\nB."+resultSet.getString(5)+"\nC."+
                        resultSet.getString(6)+"\nD."+resultSet.getString(7)+"\n答案"+resultSet.getString(8)+"\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }
}
