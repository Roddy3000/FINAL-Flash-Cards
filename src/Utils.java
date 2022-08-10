public class Utils{    
    // FlashCardsFileManager manager = new FlashCardsFileManager();

    public static void loopFromStartToEndAndViceVersa(int y){   //shorten the name
        if(FlashCardsFileManager.counter<0){
            FlashCardsFileManager.counter = y-1;
        }
        else if(FlashCardsFileManager.counter>=y){
            FlashCardsFileManager.counter =0;
        }
    }

    // public double progress() {
    //     try{
    //     return ((fileObj.getCounter()+1)/(fileObj.qnaArrayList.size()+1));  //int/int, replace it to FM class
    //     }
    //     catch(Exception e){
    //         System.out.println("error caught in progress method()!");
    //     }
    //     return 0;
    // }

    public static float updateProgress(float currentIndex, float totalValues) {
        float prog = ( currentIndex / totalValues ) ;
        return prog;
    }
}