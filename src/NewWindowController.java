import java.io.File;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;

/**
 * a new Controller Class that inherits NewWindowController
 */
public class NewWindowController extends Controller {

    FlashCardsFileManager manager = new FlashCardsFileManager();

    @FXML
    private TextField answerTextField;

    @FXML
    private Button deleteButton;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Button buttonSave;

    @FXML
    private TextField questionTextField;

    /**
     * method to delete a particular QnA
     * @param event
     */
    @FXML
    void deleteQnA(ActionEvent event) {
        System.out.println(FlashCardsFileManager.qnaArrayList.size() + "th deleted.");
        for (int i = 0; i < flowPane.getChildren().toArray().length; i++) {
            Node n = flowPane.getChildren().get(i);
            if (((CheckBox) n).isSelected()) {
                flowPane.getChildren().remove(n);
                FlashCardsFileManager.qnaArrayList.remove(i + FlashCardsFileManager.initialLength);
                saveFile();
            }
        }
    }

    /**
     * method to save file after new QnA is added
     */
    public void saveFile() {
        PrintWriter writer = null;
        try {
            File file = new File("src/QnA.txt");
            writer = new PrintWriter(file);
            for (int i = 0; i < FlashCardsFileManager.qnaArrayList.size(); i++) {
                writer.println(Integer.toString(i + 1) + ",," + FlashCardsFileManager.qnaArrayList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    int counter = 0;

    /**
     * a method to initialize the checkboxes
     */
    @FXML
    public void initialize() {
        for (QnA q : FlashCardsFileManager.qnaArrayList) {
            counter++;
            if (FlashCardsFileManager.initialLength < counter) {
                String s = (q.getQuestion().length() > 20) ? q.getQuestion().substring(0, 30) + "..." : q.getQuestion();
                CheckBox checkBox = new CheckBox(s);
                checkBox.setPrefWidth(200);
                flowPane.getChildren().add(checkBox);
            }
        }
    }

    /**
     * function to save the custom Question and Answer inputted by the user
     * @param event
     * @throws Exception
     */
    @FXML
    void saveCustomQnA(ActionEvent event) throws Exception {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Empty response");
        alert.setHeaderText("No input.");
        alert.setContentText("Enter some text to save it as Question and Answer in your flashcards file.");

        if (!(questionTextField.getText().isBlank() && answerTextField.getText().isBlank())) {
            manager.addQnaToList(questionTextField.getText(), answerTextField.getText());
            secondaryStage.close();
        } else {
            alert.show();
        }
    }

}
