public class QnaAccessor extends FlashCardsFileManager {

    // TODO move getters here

    FlashCardsFileManager manager = new FlashCardsFileManager();

    // public void fileUpdater(QnA random){
    // manager.FlashCardsFileManager.qnaArrayList.add(random);
    // }

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
}
