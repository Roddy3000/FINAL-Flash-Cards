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
}