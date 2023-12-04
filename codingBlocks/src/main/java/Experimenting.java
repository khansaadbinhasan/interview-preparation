import java.util.*;


public class Experimenting{

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run(){

        String s = "b";

        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0)-'a');
        sb.append(s.charAt(0)-'a');

        System.out.println(sb);

//        System.out.println(String.valueOf(s.charAt(0)-'a'));

    }


}