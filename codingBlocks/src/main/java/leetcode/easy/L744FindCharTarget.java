package leetcode.easy;

//["c","f","j"]
//"a"
//["c","f","j"]
//"c"
//["c","f","j"]
//"r"
//["a","b"]
//"z"
//["a","b","c","d"]
//"f"
//["c","f","j"]
//"g"
//["c","f","j"]
//"j"
public class L744FindCharTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        int[] freqArr = new int[26];

        for( int i = 0; i < letters.length; i++ ){
            freqArr[letters[i]-'a']++;
        }

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 && 'a'+i > target ) return (char)('a'+i);
        }


        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 ) return (char)('a'+i);
        }

        return 'a';
    }

}
