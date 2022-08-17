/**
 * class with question, answer and index
 */
public class QnA {

    private int questionIndex;
    private String question;
    private String answer;

    // Data transfer objects...

    QnA(int questionIndex, String question, String answer) {
        this.questionIndex = questionIndex;
        this.question = question;
        this.answer = answer;
    }

    
    /** 
     * returns the index of the QnA object
     * @return int
     */
    public int getQuestionIndex() {
        return questionIndex;
    }

    
    /** 
     * returns the Question from the QnA object
     * @return String
     */
    public String getQuestion() {
        return question;
    }

    
    /** 
     * returns the Answer from the QnA object
     * @return String
     */
    public String getAnswer() {
        return answer;
    }
    
    
    /** 
     * overrides the toString method
     * @return String
     */
    @Override
    public String toString(){
        return question+",,"+answer;
    }
}
