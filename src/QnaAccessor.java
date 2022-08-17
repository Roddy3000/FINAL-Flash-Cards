/**
 * class for accessing the next and prev QnAs and inheriting the FlashCardsFileManager class
 */
public class QnaAccessor extends FlashCardsFileManager {

    /** 
     * returns the next QnA object
     * @return QnA
     * @throws Exception
     */
    public QnA getNextQnA() throws Exception {
        if (qnaArrayList.size() == 0) {
            loadFile();
        } else {
                counter++;
        }
        Utils.loopFromStartToEnd(qnaArrayList.size());
        progress = Utils.updateProgress(counter + 1, qnaArrayList.size());
        System.out.println("Progress: " + progress); // TODO remove it later
        return qnaArrayList.get(counter);
    }

    
    /** 
     * returns the previous QnA object
     * @return QnA
     * @throws Exception
     */
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
}
