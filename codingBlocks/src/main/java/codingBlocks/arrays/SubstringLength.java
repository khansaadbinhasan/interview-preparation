package codingBlocks.arrays;

import java.util.*;

public class SubstringLength {

    public static int max(int op1, int op2){
        if( op1 > op2 )
            return op1;

        return op2;
    }

    public static int fun(List<String> stringList, int i, String s){

        if( i == stringList.size() ){
            List<Integer> freq = new ArrayList<Integer>();

            for (int j = 0; j < 26; j++) {
                freq.add(0);
            }

            for (int k = 0; k < s.length(); k++) {
                if( freq.get(s.charAt(k)-'a') == 1 ) return 0;

                freq.set(k, freq.get(s.charAt(k)-'a') + 1);
            }

            return s.length();
        }


        //We can include the ith String
        int op1 = 0;
        int op2 = 0;

        if( s.length() + stringList.get(i).length() <= 26 ){
            op1 = fun(stringList, i+1, s+stringList.get(i));
        }

        //We can exclude the ith string
        op2 = fun(stringList, i+1, s);

        return max(op1, op2);
    }

    public static int uniqueString(List<String> stringsList){
        return fun(stringsList, 0, "");
    }

    public static void main (String args[]) {

        int N = 0;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        List<String> stringList = new ArrayList<String>();

        sc.nextLine();

        for (int i = 0; i < N; i++) {
            stringList.add(sc.nextLine());
        }

        System.out.println(uniqueString(stringList));
    }

}
