package leetcode.easy;

//["--X","X++","X++"]
//["++X","++X","X++"]
//["X++","++X","--X","X--"]
public class L2011FinalValAfterOps {

    public int finalValueAfterOperations(String[] operations) {

        int val = 0;

        for(String operation: operations){
            if( operation.equals("X++") || operation.equals("++X") ) val++;
            else val--;
        }

        return val;

    }
}
