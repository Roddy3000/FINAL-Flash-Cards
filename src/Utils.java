// import java.io.File;
// import java.util.Scanner;

public class Utils {

    public static void loopFromStartToEnd(int lastValue) { // shorten the name
        if (FlashCardsFileManager.getCounter() < 0) {
            FlashCardsFileManager.setCounter(lastValue - 1);
        } else if (FlashCardsFileManager.getCounter() >= lastValue) {
            FlashCardsFileManager.setCounter(0);
        }
    }

    public static float updateProgress(float currentIndex, float totalValues) {
        float prog = (currentIndex / totalValues);
        return prog;
    }

    // private static String[] localfile;

    // public static String readfile() throws Exception {
    // localfile=null;
    // File file = new File("src/QnA.txt");
    // //TODO here
    // try (Scanner scan = new Scanner(file)) {
    // while (scan.hasNextLine()) {
    // // localfile += scan.nextLine();
    // localfile = null;

    // }
    // System.out.print("here is : " +localfile);
    // return localfile;

    // } catch (Exception e) {
    // System.out.println("Exception occured: File not found!");
    // throw e;
    // }
    // }
}