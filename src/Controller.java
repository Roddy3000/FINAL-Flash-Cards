// import java.io.FileNotFoundException;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
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
        System.out.println("Exiting the application with no error!");
        System.exit(0);
    }

    @FXML
    private void addsQuestionNAnswer(ActionEvent event) throws Exception {
        try {
            Parent newWin = FXMLLoader.load(getClass().getResource("newWindow.fxml"));
            Stage secondaryStage = new Stage();
            secondaryStage.setScene(new Scene(newWin));
            secondaryStage.setTitle("Add new Question and Answers!");
            secondaryStage.initModality(Modality.APPLICATION_MODAL);
            secondaryStage.show();
        } catch (Exception e) {
            System.out.println("Exception thrown! inside of addQnA");
        }
    }

}
