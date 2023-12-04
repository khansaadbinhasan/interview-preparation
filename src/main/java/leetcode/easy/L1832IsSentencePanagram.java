package leetcode.easy;

//"thequickbrownfoxjumpsoverthelazydog"
//"leetcode"
//"a"
//"ahfojhauifhewuihfuiwhqwertyuioplkjhgfdsazxcvbnm"
public class L1832IsSentencePanagram {

    public boolean checkIfPangram(String sentence) {

        int[] freqArr = new int[26];

        for( char c: sentence.toCharArray() ){
            freqArr[c-'a']++;
        }

        for(int freq: freqArr){
            if( freq == 0 ) return false;
        }

        return true;
    }
}
