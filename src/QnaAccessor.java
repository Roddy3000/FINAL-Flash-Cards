public class QnaAccessor {
    
    //TODO move getters here

    FlashCardsFileManager manager = new FlashCardsFileManager();

    public void fileUpdater(QnA random){
        manager.qnaArrayList.add(random);     //here TODO
    }
}
