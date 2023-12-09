package leetcode.medium;

//[2,4,3]
//[5,6,4]
//[0]
//[0]
//[9,9,9,9,9,9,9]
//[9,9,9,9]
//[5,6]
//[5,4,9]
public class L2AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        int carry = 0;

        ListNode p1 = l1;
        ListNode p2 = l2;

        if( head == null ) {
            int sum = p1.val + p2.val + carry;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            head = new ListNode(sum);
        }

        ListNode pointer = head;

        while( p1.next != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next;

            int sum = p1.val + p2.val + carry;

            carry = 0;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }

        while( p1.next != null ){
            p1 = p1.next;

            int sum = p1.val + carry;

            carry = 0;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }


        while( p2.next != null ){
            p2 = p2.next;

            int sum = p2.val + carry;

            carry = 0;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }

        if( carry == 1 ){
            pointer.next = new ListNode(1);
            pointer = pointer.next;
        }

        return head;

    }


}
