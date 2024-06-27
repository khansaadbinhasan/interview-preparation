package leetcode.medium;

import java.util.*;

public class L784LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {

        Set<String> lst = new HashSet<>();
        List<Integer> indexLst = new LinkedList<>();

        for( int i = 0; i < s.length(); i++ ){
            if(!( s.charAt(i) >= '0' && s.charAt(i) <= '9'  )){
                indexLst.add(i);
            }
        }

        for( int i: indexLst ){
            lst.add( s.substring(0,i) + s.substring(i,i+1).toUpperCase() + s.substring(i+1, s.length()) );
            lst.add( s.substring(0,i) + s.substring(i,i+1).toLowerCase() + s.substring(i+1, s.length()) );
        }

        if( indexLst.isEmpty() ) lst.add(s);

        return new LinkedList<>(lst);

    }

    public List<String> letterCasePermutation2(String s) {
        List<String> perms = new LinkedList<>();

        s = s.toLowerCase();
        perms.add(s);

        return getAllPermutations(perms, 0);
    }

    public List<String> getAllPermutations(List<String> perms, int index){
        if( index == perms.get(0).length() ) return perms;

        if( perms.get(0).charAt(index) >= '0' && perms.get(0).charAt(index) <= '9' ){
            return getAllPermutations(perms, index+1);
        }


        int n = perms.size();
        for( int i = 0; i < n; i++ ){
            perms.add(makeCapital(perms.get(i), index));
        }

        return getAllPermutations(perms, index+1);
    }

    public String makeCapital(String str, int index){
        return str.substring(0, index) + Character.toUpperCase(str.charAt(index)) + str.substring(index + 1);
    }

}
