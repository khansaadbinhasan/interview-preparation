package leetcode.easy;

public class L21MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if( l1 == null ) return l2;
        if( l2 == null ) return l1;

        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode head = head1.val < head2.val ? head1: head2;

        ListNode h1Prev = null;
        ListNode h2Prev = null;

        while( head1 != null && head2 != null ){

            if( head1.val < head2.val ) {
                ListNode h1next = head1.next;

                head1.next = head2;

                if(h2Prev != null) h2Prev.next = head1;

                head1 = h1next;

                h2Prev = head2;
            }

            else{
                ListNode h2next = head2.next;

                head2.next = head1;

                if(h1Prev != null) h1Prev.next = head2;

                head2 = h2next;

                h1Prev = head1;
            }

        }


        return head;
    }


}
