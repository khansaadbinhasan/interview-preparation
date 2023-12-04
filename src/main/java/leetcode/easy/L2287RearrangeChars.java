package leetcode.easy;


//"ilovecodingonleetcode"
//"code"
//"abcba"
//"abc"
//"abbaccaddaeea"
//"aaaaa"
//"a"
//"a"
//"aaaaaaaaaa"
//"a"
//"jaskdhfkjdashjkfdsahfjkahsdjkfadshjkfhsdjfkhasjkfhadsjkhfpopopoiouytrewqasdfgh"
//"poiu"
public class L2287RearrangeChars {
    public int rearrangeCharacters(String s, String target) {

        int[] sFreqArr = getFreqArr(s);
        int[] targetFreqArr = getFreqArr(target);


        int min = 1000;

        for( int i = 0; i < targetFreqArr.length; i++ ){

            if( targetFreqArr[i] > sFreqArr[i] ){
                return 0;
            }

            if( targetFreqArr[i] > 0 && sFreqArr[i] > 0 ){
                min = Math.min(min, sFreqArr[i]/targetFreqArr[i]);
            }
        }


        return min;
    }


    public int[] getFreqArr(String s){
        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;
    }
}
