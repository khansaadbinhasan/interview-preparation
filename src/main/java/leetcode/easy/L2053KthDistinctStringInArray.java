package leetcode.easy;

import java.util.*;

//["d","b","c","b","c","a"]
//2
//["aaa","aa","a"]
//1
//["a","b","a"]
//3
//["c","exjk","nbmg","kgnas","s","oydx","ghpao","c","r","ohdm","fq","ashgg","mm","cc","mymy","w","t","neb","grjdb","cukk","ujyhn","dq","hhuo","qu","seslw","ybulz","iug","rs","kyfu","krz","nw","txnn","r","zpuao","sh","rfc","c","hgr","jfia","egm","gmuuv","gh","x","nfvgv","ibo","al","wn","o","dyu","zgkk","gdzrf","m","ui","xwsj","zeld","muowr","d","xgiu","yfu"]
//19
public class L2053KthDistinctStringInArray {

    public static void main(String[] args) {
        new L2053KthDistinctStringInArray().run();
    }

    public void run(){
        System.out.println(kthDistinct(new String[]{"c","exjk","nbmg","kgnas","s","oydx","ghpao","c","r","ohdm","fq","ashgg","mm","cc","mymy","w","t","neb","grjdb","cukk","ujyhn","dq","hhuo","qu","seslw","ybulz","iug","rs","kyfu","krz","nw","txnn","r","zpuao","sh","rfc","c","hgr","jfia","egm","gmuuv","gh","x","nfvgv","ibo","al","wn","o","dyu","zgkk","gdzrf","m","ui","xwsj","zeld","muowr","d","xgiu","yfu"}, 19));
    }

    public String kthDistinct(String[] arr, int k) {

        List<String> lst = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> duplicateSet = new HashSet<>();



        for( int i = 0; i < arr.length; i++ ){
            if( set.contains(arr[i]) && !duplicateSet.contains(arr[i]) ){
                duplicateSet.add(arr[i]);
                set.remove(arr[i]);
            }

            else if( !duplicateSet.contains(arr[i]) ){
                set.add(arr[i]);
            }
        }

        for( int i = 0; i < arr.length; i++ ){
            if( set.contains(arr[i]) ){
                lst.add(arr[i]);
            }
        }

        return (k-1) < lst.size() ? lst.get(k-1): "";
    }
}
