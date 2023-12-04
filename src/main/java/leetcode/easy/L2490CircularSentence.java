package leetcode.easy;


//"leetcode exercises sound delightful"
//"eetcode"
//"Leetcode is cool"
//"a"
//"eetcok"
//"RamoR"
//"pop"
public class L2490CircularSentence {

    public boolean isCircularSentence(String sentence) {

        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length-1; i++){
            if( !words[i].endsWith(words[i+1].substring(0,1)) ) {
                return false;
            }
        }

        if( !words[words.length-1].endsWith(words[0].substring(0,1)) ) {
            return false;
        }

        return true;
    }

}
