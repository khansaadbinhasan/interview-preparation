package leetcode.easy;

//["cba","daf","ghi"]
//["a","b"]
//["zyx","wvu","tsr"]
//["a"]
//["rrjk","furt","guzm"]
public class L944DeleteColsToMakeSorted {

    public int minDeletionSize(String[] strs) {

        int numDeletions = 0;

        for( int j = 0; j < strs[0].length(); j++ ){

            boolean isSorted = true;

            int prev = strs[0].charAt(j);

            for( int i = 1; i < strs.length; i++ ){
                if( strs[i].charAt(j) - prev < 0 ) {
                    isSorted = false;
                    break;
                }

                prev = strs[i].charAt(j);
            }

            if( !isSorted ) numDeletions++;
        }

        return numDeletions;
    }

}
