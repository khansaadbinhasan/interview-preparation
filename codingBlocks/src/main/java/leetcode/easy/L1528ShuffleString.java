package leetcode.easy;

//"codeleet"
//[4,5,6,7,0,2,1,3]
//"abc"
//[0,1,2]
//"aiohn"
//[3,1,4,2,0]
//"aaiougrt"
//[4,0,2,6,7,3,1,5]
//"art"
//[1,0,2]
//"a"
//[0]

public class L1528ShuffleString {

    public String restoreString(String s, int[] indices) {

        char[] sCharArr = s.toCharArray();

        for( int i = 0; i < indices.length; i++ ){
            sCharArr[indices[i]] = s.charAt(i);
        }

        return String.valueOf(sCharArr);
    }
}
