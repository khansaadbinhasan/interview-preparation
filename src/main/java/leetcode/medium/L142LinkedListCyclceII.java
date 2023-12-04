package leetcode.medium;

//[3,2,0,-4]
//1
//[1,2]
//0
//[1]
//-1
//[1,2,3]
//1
//[]
//-1
//[1,2,3,4,5,6,7,8]
//-1
//[1,2,3,4,5,6,7,8]
//3
//[1,2]
//-1
//[1,2,3]
//-1
public class L142LinkedListCyclceII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while( slow != null && fast != null && fast.next != null ){

            slow = slow.next;
            fast = fast.next.next;

            if( slow == fast ) break;
        }

        if( slow == null || fast == null || fast.next == null ) return null;

        slow = head;

        while( slow != fast ){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;

    }


}
