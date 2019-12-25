package club.banyuan.project.pojo;

public class Question {
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
        return "Question{" +
                "queNum=" + queNum +
                ", queName='" + queName + '\'' +
                ", queTitle='" + queTitle + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", queAnswer='" + queAnswer + '\'' +
                '}';
    }
}
