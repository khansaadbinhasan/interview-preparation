package misc.advancedRecursion;

import java.util.HashSet;
import java.util.Set;

public class PermutationsOfString {

    public static void main(String[] args) {
        new PermutationsOfString().run();
    }

    Set<String> strSet = new HashSet<>();

    private void run() {

        permutation("acc", 0, 2);

    }

    public void permutation(String s, int l, int r){
        if( l == r ){
            if( strSet.contains(s) ) return;

            strSet.add(s);
            System.out.println(s);

            return;
        }

        for (int i = l; i <= r; i++) {

            s = interchangeChar(s, l, i);
            permutation(s, l+1, r);
            s = interchangeChar(s, i, l);
        }


    }

    public String interchangeChar(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);

        char charAti = s.charAt(i);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, charAti);

        return sb.toString();
    }
}
