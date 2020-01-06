package club.banyuan.project.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Question implements Serializable {
    private int queNum;
    private String queName;
    private String queTitle;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String queAnswer;

    public int getQueNum() {
        return queNum;
    }

    public void setQueNum(int queNum) {
        this.queNum = queNum;
    }

    public String getQueName() {
        return queName;
    }

    public void setQueName(String queName) {
        this.queName = queName;
    }

    public String getQueTitle() {
        return queTitle;
    }

    public void setQueTitle(String queTitle) {
        this.queTitle = queTitle;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getQueAnswer() {
        return queAnswer;
    }

    public void setQueAnswer(String queAnswer) {
        this.queAnswer = queAnswer;
    }

    @Override
    public String toString() {
        return
                 queTitle +
                 optionA +
                 optionB +
               optionC +
                optionD
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return queNum == question.queNum &&
                Objects.equals(queName, question.queName) &&
                Objects.equals(queTitle, question.queTitle) &&
                Objects.equals(optionA, question.optionA) &&
                Objects.equals(optionB, question.optionB) &&
                Objects.equals(optionC, question.optionC) &&
                Objects.equals(optionD, question.optionD) &&
                Objects.equals(queAnswer, question.queAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queNum, queName, queTitle, optionA, optionB, optionC, optionD, queAnswer);
    }
}
