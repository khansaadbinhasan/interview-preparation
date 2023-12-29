package leetcode.medium;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
public class L382LinkedListRandomNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode head;
    ListNode p;

    public L382LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.p = head;
    }

    public int getRandom() {
        p = head;
        int i = 1;
        int res = 0;

        while( p != null ){
            if( Math.random() < (1.0/i) ) res=p.val;
            p = p.next;
            i++;
        }

        return res;
    }
}