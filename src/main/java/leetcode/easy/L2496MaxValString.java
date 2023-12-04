package leetcode.easy;


//["alic3","bob","3","4","00000"]
//["1","01","001","0001"]
public class L2496MaxValString {

    public int maximumValue(String[] strs) {

        int max = 0;

        for( String s: strs ){
            max = Math.max(max, getStringVal(s));
        }

        return max;

    }

    public int getStringVal(String s){

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ){
                return s.length();
            }
        }

        return Integer.parseInt(s);
    }
}
