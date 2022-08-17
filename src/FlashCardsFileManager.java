import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
// import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Flash Cards file manager class
 */
public class FlashCardsFileManager {


    public static int initialLength;
    public static ArrayList<QnA> qnaArrayList = new ArrayList<QnA>();

    private final String FILENAME = "src/QnA.txt";
    public static int counter = 0;
    // public static boolean answerVisible = false;
    public QnA quesAndAnsObj;
    public float progress;

    
    /** 
     * sets the counter (aka QnA index)                         //doesn't really needed to add counter but I already went way too 
     * @param counter                                           //deep to remove the index, so sorry about that, that indexing was meant for
     */                                                         //some rating stuff but I eventually dumped the idea cuz everything was getting complex and the deadline was approaching
    public static void setCounter(int counter) {
        FlashCardsFileManager.counter = counter;
    }

    
    /** 
     * return the progress (as float)
     * @return float
     */
    public float getProgress() {
        return progress;
    }

    
    /** 
     * returns the filename (as a path)
     * @return String
     */
    public String getFileName() {
        return FILENAME;
    }

    
    /** 
     * returns the value of counter
     * @return int
     */
    public static int getCounter() {
        return FlashCardsFileManager.counter;
    }

    
    /** 
     * returns the Qna object
     * @return QnA
     */
    public QnA getQuesAndAnsObj() {
        return quesAndAnsObj;
    }
    
    
    /** 
     * load the file in the object
     * @throws Exception
     */
    public void loadFile() throws Exception {

        File file = new File(FILENAME);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String[] parsedString = scan.nextLine().split(",,");
                quesAndAnsObj = new QnA(Integer.parseInt(parsedString[0]), parsedString[1], parsedString[2]);
                qnaArrayList.add(quesAndAnsObj);
            }
            initialLength=qnaArrayList.size();
        } catch (Exception e) {
            System.out.println("Exception occured: File not found!");
            throw e;
        }
    }

    
    /** 
     * adds the Qna object to the qnaArrayList
     * @param que String for question
     * @param ans String for answer
     * @throws Exception
     */
    public void addQnaToList(String que, String ans) throws Exception {
        if (qnaArrayList.size() == 0) {
            loadFile();
        }
        qnaArrayList.add(new QnA(qnaArrayList.size() + 1, que, ans));
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(FILENAME, true))) {
            printWriter.print("\n" + Integer.toString(qnaArrayList.size()) + ",," + que + ",," + ans);
            // loadFile();
        } catch (Exception e) {
            System.out.println("Exception caught inside of addqnatolist method");
            System.out.println(e.getMessage());
        }
    }
}
