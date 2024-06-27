package leetcode.medium;

//[5,2,13,3,8]
//[1,1,1,1]
//[1,2,3,4,5]
//[1]
//[5,4,3,2,1]
//[2,2,5,4,3,2,1,6,7,4,3,2,8]
public class L2487RemoveNodeFromLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNodes(ListNode head) {
        return reverseLinkedList(removeSmaller(reverseLinkedList(head)));
    }

    public ListNode removeSmaller(ListNode head){
        int max = head.val;
        ListNode node = head;
        while( node != null && node.next != null ){
            if( node.next.val < max ){
                node.next = node.next.next;
            }

            else{
                max = node.next.val;
                node = node.next;
            }
        }

        return head;
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while( current != null ){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        new L2487RemoveNodeFromLinkedList().run();
    }

    public void run(){
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        removeNodes(head);
    }

    public void printLL(ListNode n){
        while( n != null ){
            System.out.print(n.val + "->");
            n = n.next;
        }
        System.out.println();
    }
}
