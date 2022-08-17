/**
 * Utility class with static methods               
 */
public class Utils {

    
    /** 
     * method to loop from start to end for the list
     * @param 0
     */
    public static void loopFromStartToEnd(int lastValue) { // shorten the name
        if (FlashCardsFileManager.getCounter() < 0) {
            FlashCardsFileManager.setCounter(lastValue - 1);
        } else if (FlashCardsFileManager.getCounter() >= lastValue) {
            FlashCardsFileManager.setCounter(0);
        }
    }

    
    /** 
     * updates the progress (for the progress bar)
     * @param currentIndex
     * @param totalValues
     * @return float
     */
    public static float updateProgress(float currentIndex, float totalValues) {
        float prog = (currentIndex / totalValues);
        return prog;
    }


    //I wanted to add more but it is what it is now :(
}