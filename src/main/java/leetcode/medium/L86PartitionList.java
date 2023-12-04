package leetcode.medium;

public class L86PartitionList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public ListNode partition(ListNode head, int x) {

        if( head == null ) return null;

        if( head.val >= x ){

            ListNode node1 = head;

            while( node1.next != null && node1.next.val >= x ) node1 = node1.next;

            if( node1.next != null ){
                ListNode node2 = node1.next;

                while( node2.next != null && node2.next.val < x )
                    node2 = node2.next;

                ListNode oldHead = head;

                head = node1.next;
                node1.next = node2.next;
                node2.next = oldHead;
            }
        }


        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while( pointer1 != null ){

            while( pointer1.next != null && pointer1.next.val < x ){
                pointer1 = pointer1.next;
            }

            if( pointer1.next == null ) break;

            if( head.val < x )
                pointer2 = pointer1.next;

            while( pointer2.next != null && pointer2.next.val >= x ){
                pointer2 = pointer2.next;
            }

            if( pointer2.next == null ) break;

            ListNode pointer3 = pointer2.next;

            while( pointer3.next != null && pointer3.next.val < x ){
                pointer3 = pointer3.next;
            }

            if( pointer3 == null ) break;

            ListNode pointer4 = pointer1.next;
            ListNode pointer5 = pointer3.next;

            pointer1.next = pointer2.next;
            pointer2.next = pointer5;
            pointer3.next = pointer4;

            pointer1 = pointer3;
        }

        return head;
    }


}
