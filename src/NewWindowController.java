import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewWindowController {


    @FXML
    private TextField answerTextField;

    @FXML
    private Button buttonSave;

    @FXML
    private TextField questionTextField;

    @FXML
    void saveCustomQnA(ActionEvent event) throws Exception {
        Controller.manager.addQnaToList(questionTextField.getText(), answerTextField.getText());
        Controller.secondaryStage.close();
    }
    // public void setStage(Stage stage){
    //     newStage=stage;
    // }

}
