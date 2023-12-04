package leetcode.easy;

//[1,2,3,4,5]
//[1,2]
//[]
//[1,2,3,4,5,6]
//[1,3]
//[1]

public class L206ReverseLinkedList {

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseList(ListNode head) {

        if( head == null ) return null;

        ListNode pointer1 = head.next;

        if( pointer1 == null ) return head;

        ListNode pointer2 = pointer1.next;

        pointer1.next = head;
        head.next = null;
        head = pointer1;

        while( pointer2 != null ){
            pointer1 = pointer2;
            pointer2 = pointer2.next;
            pointer1.next = head;
            head = pointer1;
        }

        return head;
    }
    
}
