package leetcode.easy;

import java.util.*;

//["alice","bob","charlie"]
//"abc"
//["an","apple"]
//"a"
//["never","gonna","give","up","on","you"]
//"ngguoy"
//["never","gonna","give","you","up"]
//"nggyu"
//["never","gonna","give","you","up"]
//"nggyou"
//["abc"]
//"a"
//["abc"]
//"b"
public class L2828CheckIfStringIsAcronymn {

    public boolean isAcronym(List<String> words, String s) {

        String acr = "";

        for( String w: words ){
            acr += String.valueOf(w.charAt(0));
        }

        return acr.equals(s);
    }
}
