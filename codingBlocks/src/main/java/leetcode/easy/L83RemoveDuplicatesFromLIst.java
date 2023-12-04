package leetcode.easy;

//[1,1,2]
//[1,1,2,3,3]
//[]
//[1]
//[1,1]
//[1,2,3,3]
//[1,2,2,3,3]
public class L83RemoveDuplicatesFromLIst {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while( pointer1 != null ){

            pointer2 = pointer1;
            // pointer1 = pointer1.next;

            while( pointer1 != null && pointer1.next != null &&
                    pointer1.val == pointer1.next.val ) {
                pointer1 = pointer1.next;
            }

            pointer2.next = pointer1.next;
            pointer1 = pointer1.next;

        }

        return head;
    }


}
