import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
// import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
// import javafx.scene.control.Cell;
// import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.stage.Modality;
// import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Button addQnA;

    @FXML
    private Button exitButton;

    @FXML
    private Label labelAnswer;

    @FXML
    private Label labelQuestion;

    @FXML
    private Button nextButton;

    @FXML
    private Button previousButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button showAnswer;

    @FXML
    private Tooltip toolTip1;

    @FXML
    private Label progressLabel;

    private QnA currentQuestionAndAnswer = null;

    private QnaAccessor quesAndAns = new QnaAccessor();
    private Parent newWin;
    public static Stage secondaryStage;

    
    /** 
     * Event handler for revealing the answer
     * @param event
     * @throws Exception
     */
    @FXML
    void revealAnswer(ActionEvent event) throws Exception {
        if (FlashCardsFileManager.qnaArrayList.size() == 0) {
            labelAnswer.setText("Please load the file by clicking the next button!");
        }
        else{
            labelAnswer.setText(currentQuestionAndAnswer.getAnswer());
        }
    
    }

    
    /**
     * Event handler for clicking of next button 
     * @throws Exception
     */
    @FXML
    private void nextButtonClicked() throws Exception {
        toolTip1.setShowDelay(Duration.seconds(0.2));
        currentQuestionAndAnswer = quesAndAns.getNextQnA();
        try {
            labelQuestion.setText(currentQuestionAndAnswer.getQuestion());
            labelAnswer.setText("Answer here!");
        } catch (Exception e) {
            System.out.println("Exception thrown in next button!");
        }
        updateProgressBar();
    }

    
    /** 
     * Event handler for clicking of previous button
     * @throws Exception
     */
    @FXML
    private void previousButtonClicked() throws Exception {
        currentQuestionAndAnswer = quesAndAns.getPrevQnA();
        try {
            labelQuestion.setText(currentQuestionAndAnswer.getQuestion());
            labelAnswer.setText("Answer here!");
        } catch (Exception e) {
            System.out.println("exception thrown!");
        }
        updateProgressBar();
    }

    
    /** 
     * event handler for exiting the gui
     * @param event
     */
    @FXML
    private void exitWithNoError(ActionEvent event) {
        System.out.println("\nExiting the application with no error!\n");
        System.exit(0);
    }

    
    /** 
     * Event handler for adding a question
     * @param event
     * @throws Exception
     */
    @FXML
    private void addsQuestionNAnswer(ActionEvent event) throws Exception {
        try {
            newWin = FXMLLoader.load(getClass().getResource("newWindow.fxml"));
            secondaryStage = new Stage();
            secondaryStage.setScene(new Scene(newWin));
            secondaryStage.setTitle("Add new Question and Answers!");
            secondaryStage.initModality(Modality.APPLICATION_MODAL);
            secondaryStage.show();
        } catch (Exception e) {
            System.out.println("Exception thrown! inside of addQnA");
            System.out.println(e.getStackTrace());
            // System.out.println(e.getMessage());
        }
    }

    /**
     * updation of the progress bar
     */
    private void updateProgressBar() {
        progressBar.setProgress(quesAndAns.getProgress());
        updateProgressLabel();
    }

    /**
     * updating the progress label
     */
    public void updateProgressLabel(){
        int index = currentQuestionAndAnswer.getQuestionIndex();
        int total = FlashCardsFileManager.qnaArrayList.size();
        String prog = Integer.toString(index) + "/" + Integer.toString(total);
        progressLabel.setText(prog);
    }

}
