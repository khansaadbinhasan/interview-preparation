package leetcode.easy;

//"Hello, my name is John"
//"Hello"
//" Hello "
//"this  si spaced   str"
//"this   "
//"that "
//"          this         that rna                "
//" some space        is        gooood  "
public class L434SegmentsInString {

    public int countSegments(String s) {

        String[] sArr = s.trim().split(" ");

        int count = 0;

        for( int i = 0; i < sArr.length; i++ ){
            if( !sArr[i].isEmpty() ) count++;
        }

        return count;
    }

}
