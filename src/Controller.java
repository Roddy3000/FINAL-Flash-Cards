// import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
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
    private Tooltip toolTip;

    public QnA currentQuestionAndAnswer = null;
    FlashCardsFileManager manager = new FlashCardsFileManager();

    @FXML
    private void nextButtonClicked() throws Exception {
        currentQuestionAndAnswer = manager.getNextQnA();
        try {
            if (FlashCardsFileManager.answerVisible) {
                labelAnswer.setText(currentQuestionAndAnswer.getAnswer());
            } else {
                labelAnswer.setText("Answer here");
            }
            labelQuestion.setText(currentQuestionAndAnswer.getQuestion());
        } catch (Exception e) {
            System.out.println("exception thrown!");
        }
        updateProgressBar();
        toolTip.setShowDelay(Duration.seconds(0.2));
    }

    @FXML
    private void previousButtonClicked() throws Exception {
        currentQuestionAndAnswer = manager.getPrevQnA();
        try {
            labelQuestion.setText(currentQuestionAndAnswer.getQuestion());
            labelAnswer.setText(currentQuestionAndAnswer.getAnswer());
        } catch (Exception e) {
            System.out.println("exception thrown!");
        }
        updateProgressBar();
    }

    private void updateProgressBar() {
        progressBar.setProgress(manager.getProgress());
    }

    @FXML
    private void exitWithNoError(ActionEvent event) {

    }

    
    private void addsQuestionNAnswer(){

    }
    

}
