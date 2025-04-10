public class PlayingCat {
    // write code here
    public static boolean isCatPlaying (boolean summer, int tempratrure){
        if(summer && tempratrure >= 25 && tempratrure <= 45){
            return true;
        }
        else if(summer == false &&  tempratrure >= 25 && tempratrure <= 35){
            return true;
        }
        return false;
    }
}