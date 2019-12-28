package club.banyuan.project.dao;

import java.util.Set;

public interface QuestionDao {

    //选题序一定数量无重复的题目 ，返回值和参数还不确定

    Set selQues(String queName);
}
