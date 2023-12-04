package leetcode.easy;

//"A man, a plan, a canal: Panama"
//"race a car"
//"adhdgkdashfg"
//"afkdjasfhkldsg"
//"aplalpa"
//"thtis s dasfkdsalgfk"
//"a"
//"alallalalalla"
//"aaaaaaaaaaaaaa"
//"zzzzzzzzzzzzzzzz"
//"abcdedcba"
//"0P"
//"ab2a"

public class L125ValidPalindrome {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int ind1 = 0;
        int ind2 = s.length()-1;

        while( ind1 < ind2 ){

            while( ind1 < ind2 &&
                    !(s.charAt(ind1) >= 'a' && s.charAt(ind1) <= 'z') &&
                    !(s.charAt(ind1) >= '0' && s.charAt(ind1) <= '9') ) ind1++;

            while( ind1 < ind2 &&
                    !(s.charAt(ind2) >= 'a' && s.charAt(ind2) <= 'z') &&
                    !(s.charAt(ind2) >= '0' && s.charAt(ind2) <= '9') ) ind2--;

            if( ind1 < ind2 && s.charAt(ind1) != s.charAt(ind2) ) return false;

            ind1++;
            ind2--;
        }

        return true;
    }

}
