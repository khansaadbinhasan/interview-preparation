package leetcode.medium;

//[1,8,9]
//[9,9,9]
//[1]
//[3,4,2,1,3,4,9,9,9,8,7,8,9,9,8,7,9,2,3,4,5,1,0]
//[1,0,0,0]
public class L2816DoubleNumberRepresentedAsLL {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode doubleIt(ListNode head) {

        head = reverse(head);

        int carry = 0;
        ListNode headFirst = head;
        ListNode prev = head;

        while( head != null ){
            int sum = head.val*2+carry;
            int dig = sum%10;
            head.val = dig;
            prev = head;
            head = head.next;
            carry = sum/10;
        }

        if( head == null && carry != 0 ) prev.next = new ListNode(carry);

        return reverse(headFirst);
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;

        while( head != null ){
            ListNode n = head;
            head = head.next;
            n.next = prev;
            prev = n;
        }

        return prev;
    }

}
