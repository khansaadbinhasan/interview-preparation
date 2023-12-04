package leetcode.easy;

//"51230100"
//"123"
//"890"
public class L2710RemoveTrailingZeros {

    public String removeTrailingZeros(String num) {

        String[] nums = num.split("");


        String finalNum = "";
        int finalI = nums.length-1;

        while( nums[finalI].equals("0") ) finalI--;

        for( int i = 0; i <= finalI; i++ ){
            finalNum += nums[i];
        }

        return finalNum;

    }
}
