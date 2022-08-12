import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
// import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlashCardsFileManager {

    public static ArrayList<QnA> qnaArrayList = new ArrayList<QnA>();

    private final String fileName = "src/QnA.txt";
    public static int counter = 0;
    public static boolean answerVisible = false;
    private QnA quesAndAnsObj;
    public float progress;

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

    public void addQnaToList(String que, String ans) throws Exception {
        if (qnaArrayList.size() == 0) {
            loadFile();
        }
        qnaArrayList.add(new QnA(qnaArrayList.size() + 1, que, ans));
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true))) {
            printWriter.print("\n" + Integer.toString(qnaArrayList.size()) + ",," + que + ",," + ans);
            // loadFile();
        } catch (Exception e) {
            System.out.println("Exception caught inside of addqnatolist method");
            System.out.println(e.getMessage());
        }
    }
}
