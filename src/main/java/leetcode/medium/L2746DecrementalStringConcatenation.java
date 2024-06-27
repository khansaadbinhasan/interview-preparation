package leetcode.medium;


import java.util.Arrays;
import java.util.LinkedList;

//["aa","ab","bc"]
//["ab","b"]
//["aaa","c","aba"]
//["abc", "cab", "kladf", "lka", "plplsaaoaoa", "dksahfjlaaaa"]
//["a"]
//["a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"]
//["abc","cba","lkkaj","aba","abc","cba","lkkaj","aba","cba","lkkaj","aba","lkkaj","ababbb","aacba","lkkajaa","cba","lkkaj","aba","lkkaj","ababbb","aacba","lkkajaa"]
//["bfbfa","jbe","ggc","faidg","c","g","dhd","eeha","h","egajf","eddfi","d","a","acb","ca","ca","ffg","f","ab","cgcj","eij"]
public class L2746DecrementalStringConcatenation {

    public static void main(String[] args) {
        new L2746DecrementalStringConcatenation().run();
    }

    public void run(){
        System.out.println(minimizeConcatenatedLength(new String[]{}));
    }

    public int minimizeConcatenatedLength(String[] words) {
        LinkedList<String> lst = new LinkedList<>(Arrays.asList(words));
        return minStr(lst);
    }

    public int minStr(LinkedList<String> lst){
        if( lst.size() == 1 ) return lst.get(0).length();

        String s2 = join(lst.get(1), lst.get(0));
        String s1 = join(lst.removeFirst(), lst.removeFirst());

        LinkedList<String> lst1 = new LinkedList<>(lst);
        LinkedList<String> lst2 = new LinkedList<>(lst);

        lst1.addFirst(s1);
        int minStr1 = minStr(lst1);
        lst2.addFirst(s2);
        int minStr2 = minStr(lst2);

        return Math.min(minStr1, minStr2);
    }

    public String join(String s1, String s2){
        StringBuilder s1sb = new StringBuilder(s1);
        if( s1.charAt(s1.length()-1) == s2.charAt(0) ){
            s1sb.deleteCharAt(s1.length()-1);
        }

        s1sb.append(s2);

        return s1sb.toString();
    }
}
