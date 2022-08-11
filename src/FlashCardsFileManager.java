import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
// import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlashCardsFileManager {

    public ArrayList<QnA> qnaArrayList = new ArrayList<QnA>();

    private final String fileName = "src/QnA.txt";
    private static int counter = 0;
    public static boolean answerVisible = false;
    private QnA quesAndAnsObj;
    private float progress;

    public static void setCounter(int counter) {
        FlashCardsFileManager.counter = counter;
    }

    public float getProgress() {
        return progress;
    }

    public String getFileName() {
        return fileName;
    }

    public static int getCounter() {
        return counter;
    }

    public QnA getQuesAndAnsObj() {
        return quesAndAnsObj;
    }

    public void loadFile() throws Exception {
        File file = new File(fileName);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String[] parsedString = scan.nextLine().split(",,");
                quesAndAnsObj = new QnA(Integer.parseInt(parsedString[0]), parsedString[1], parsedString[2]);
                qnaArrayList.add(quesAndAnsObj);
            }
        } catch (Exception e) {
            System.out.println("Exception occured: File not found!");
            throw e;
        }
    }

    public QnA getNextQnA() throws Exception {

        if (qnaArrayList.size() == 0) {
            loadFile();
        } else {
            if (answerVisible) {
                answerVisible = false;
                counter++;
            } else {
                answerVisible = true;
            }
        }
        Utils.loopFromStartToEnd(qnaArrayList.size());
        progress = Utils.updateProgress(counter + 1, qnaArrayList.size());
        System.out.println("Progress: " + progress); // TODO remove it later
        return qnaArrayList.get(counter);
    }

    public QnA getPrevQnA() throws Exception {

        if (qnaArrayList.size() == 0) {
            loadFile();
        } else {
            counter--;
        }
        Utils.loopFromStartToEnd(qnaArrayList.size());
        progress = Utils.updateProgress(counter + 1, qnaArrayList.size());
        System.out.println("Progress: " + progress);
        return qnaArrayList.get(counter);
    }

    public void addQnaToList() throws FileNotFoundException {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {

        } catch (Exception e) {
            System.out.println("Exception caught inside of addqnatolist method");
            System.out.println(e.getMessage());
        }
    }
}
