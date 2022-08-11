import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewWindowController {

    public String newCustomQuestion;
    
    @FXML
    private TextField answerTextField;

    @FXML
    private Button buttonSave;

    @FXML
    private TextField questionTextField;

    @FXML
    void saveCustomQnA(ActionEvent event) {
        newCustomQuestion = questionTextField.getText();
    }

}
