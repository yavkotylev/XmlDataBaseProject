package sample;

public class Utils {
    public static boolean isBlank(String s){
        if (s != null && s.length() > 0 && s.trim().length() > 1) {
            return false;
        }
        return true;
    }
}
