import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run() {
        List<Integer> arr = new ArrayList<>(5);

        System.out.println("Integer.MAX_VALUE".hashCode());
        System.out.println("Integer".hashCode());
        System.out.println("thish ioahkfahskdhf s fjdhfkjdshf kjdsahf kdjhfakjsdhfkjh".hashCode());


        LinkedList<Integer> lst = new LinkedList<>();

        lst.add(1);
        lst.add(2);

        System.out.println(lst.remove(0));
        System.out.println(lst.indexOf(2));

    }
}



