package leetcode.easy;


//[1,2,4], [1,3,4]
//[], []
//[], [0]
public class L21MergeTwoLists {

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;

        if( head1 == null ) return head2;
        if( head2 == null ) return head1;


        ListNode head;

        if( head1.val <= head2.val ){
            head = head1;
            head1 = head1.next;
        }

        else{
            head = head2;
            head2 = head2.next;
        }

        ListNode newList = head;

        while( head1 != null && head2 != null ){
            if( head1.val <= head2.val ){
                newList.next = head1;
                head1 = head1.next;
            }

            else{
                newList.next = head2;
                head2 = head2.next;
            }

            newList = newList.next;
        }

        while( head1 != null ){
            newList.next = head1;
            head1 = head1.next;
            newList = newList.next;
        }

        while( head2 != null ){
            newList.next = head2;
            head2 = head2.next;
            newList = newList.next;
        }

        return head;
    }

}
