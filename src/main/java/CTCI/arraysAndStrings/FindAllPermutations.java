package CTCI.arraysAndStrings;

import java.util.*;

public class FindAllPermutations {

    public static void main(String[] args) {
        new FindAllPermutations().run();
    }

    public void run(){
        System.out.println(perm("abc"));
    }

    //a --> [a]
    //b --> [b]
    //ab --> [ab, ba]
    //abc --> [abc, acb, bac, bca, cab, cba]
    public List<String> perm(String s){
        if( s.isEmpty() ) return new ArrayList<>();
        if( s.length() == 1 ) return Arrays.asList(s);

        List<String> lst = new ArrayList<>();//[abc, acb, bac, bca, cab, cba]


        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);//abc
            String c = s.substring(i,i+1);//c
            sb.delete(i,i+1);
            List<String> perm = perm(sb.toString());//ab --> [ab, ba]

            for (int j = 0; j < perm.size(); j++) {
                lst.add(c+perm.get(j));
            }
        }

        return lst;
    }

}
