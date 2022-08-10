public class QnA {

    private int questionIndex;
    private String question;
    private String answer;

    // Date transfer objects...

    QnA(int questionIndex, String question, String answer) {
        this.questionIndex = questionIndex;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    // public void setQuestionIndex(int questionIndex) {
    // this.questionIndex = questionIndex;
    // }
    public String getQuestion() {
        return question;
    }

    // public void setQuestion(String question) {
    // this.question = question;
    // }
    public String getAnswer() {
        return answer;
    }
    // public void setAnswer(String answer) {
    // this.answer = answer;
    // }

}
