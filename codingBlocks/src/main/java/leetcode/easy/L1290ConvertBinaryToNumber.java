package leetcode.easy;


//[1,0,1]
//[0]
//[1]
//[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//[0,0]
public class L1290ConvertBinaryToNumber {

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public int getDecimalValue(ListNode head) {

        String bin = "";

        while( head != null ){
            bin += String.valueOf(head.val);

            head = head.next;
        }

        int num = 0;

        for( int i = bin.length() - 1; i >= 0; i-- ){

            int n = bin.charAt(i) - '0';

            num += n * Math.pow(2, bin.length() - i - 1);
        }

        return num;
    }


}
