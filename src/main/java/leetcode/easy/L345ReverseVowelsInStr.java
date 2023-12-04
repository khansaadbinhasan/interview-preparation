package leetcode.easy;

import java.util.*;

//"hello"
//"leetcode"
//"adsklfakldhfjakshfkjtusghufhdajksfhgsuagfjksdhfjkashfdj"
//"a"
//"aaaeeeeioiouuuu"
//"dkasfhkjadhjuiuiuiuieueieieueueeeooo"
//"aAAAAAAAAAAAAEEUIUEIUIAAAOOOOoioiouop))(99989*&86G)"
public class L345ReverseVowelsInStr {

    public String reverseVowels(String s) {

        Stack<Character> vowelStack = new Stack<>();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');

        for( int i = 0; i < s.length(); i++ ){
            if( vowels.contains(s.charAt(i)) )
                vowelStack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();


        for( int i = 0; i < s.length(); i++ ){
            String a = String.valueOf((char) s.charAt(i));

            if( vowels.contains(s.charAt(i)) ) a = vowelStack.pop().toString();

            sb.append(a);
        }

        return sb.toString();
    }
}
