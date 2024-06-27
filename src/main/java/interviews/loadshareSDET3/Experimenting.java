package interviews.loadshareSDET3;

import java.util.*;


public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run() {
        boolean[] arr = new boolean[5];

        boolean[] arr2 = arr.clone();

        arr2[0] = true;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

}



