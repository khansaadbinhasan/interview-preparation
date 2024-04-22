import java.util.*;


public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run() {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'E', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
        System.out.println("abz".compareTo("ababz"));

//        new StringBuilder().replace()
    }

    public String getArray(String arr){
        return arr.replaceAll("\\[","\\{").replaceAll("\\]","\\}");
    }
}



