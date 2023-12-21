package leetcode.medium;

//[1]
//[1,2]
//[1,2,3]
//[1,2,3,4]
//[1,2,3,4,5]
//[1,2,3,4,5,6]
//[1,2,3,4,5,6,7]
public class L143ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        new L143ReorderList().run();
    }

    public void run(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        reorderList(head);
    }

    public void reorderList(ListNode head) {
        ListNode p1 = head;

        while( p1 != null && p1.next != null && p1.next.next != null ){
            ListNode p2 = getSecondLastPointer(head);

            p2.next.next = p1.next;
            p1.next = p2.next;
            p2.next = null;
            p1 = p1.next.next;
        }
    }

    public ListNode getSecondLastPointer(ListNode head){
        if( head == null || head.next == null ) return null;

        ListNode p = head;
        head = head.next;

        while( head.next != null ){
            head = head.next;
            p = p.next;
        }

        return p;
    }

}
