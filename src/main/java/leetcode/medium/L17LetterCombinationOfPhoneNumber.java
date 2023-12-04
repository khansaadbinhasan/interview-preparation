package leetcode.medium;

import java.util.*;

//"23"
//""
//"2"
//"429"
//"3449"
//"9999"
//"9"
public class L17LetterCombinationOfPhoneNumber {

    public List<String> letterCombinations(String digits) {

        if( digits.length() == 0 ) return new ArrayList<>();

        int[] phoneNumber = new int[digits.length()];

        for( int i = 0; i < digits.length(); i++ ){
            phoneNumber[i] = digits.charAt(i)-'0';
        }

        List<String> numbersTillNow = getTelephoneHashmap().get(phoneNumber[0]);

        return telephoneAlphaPrint(numbersTillNow, phoneNumber, 1);
    }


    public List<String> telephoneAlphaPrint(List<String> numbersTillNow, int[] phoneNumber, int i){

        if( i == phoneNumber.length ) return numbersTillNow;

        List<String> nextNum = getTelephoneHashmap().get(phoneNumber[i]);

        List<String> newNumbersTillNow = new ArrayList<>();

        for (int j = 0; j < numbersTillNow.size(); j++) {
            for (int k = 0; k < nextNum.size(); k++) {
                newNumbersTillNow.add(numbersTillNow.get(j)+nextNum.get(k));
            }
        }

        return telephoneAlphaPrint(newNumbersTillNow, phoneNumber, i+1);
    }

    public Map<Integer, List<String>> getTelephoneHashmap(){

        Map<Integer, List<String>> m = new HashMap<>();

        m.put(2, Arrays.asList("a", "b", "c"));
        m.put(3, Arrays.asList("d", "e", "f"));
        m.put(4, Arrays.asList("g", "h", "i"));
        m.put(5, Arrays.asList("j", "k", "l"));
        m.put(6, Arrays.asList("m", "n", "o"));
        m.put(7, Arrays.asList("p", "q", "r", "s"));
        m.put(8, Arrays.asList("t", "u", "v"));
        m.put(9, Arrays.asList("w", "x", "y", "z"));

        return m;
    }


}
