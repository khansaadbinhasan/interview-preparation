package leetcode.medium;


import java.util.*;

//[4,2,1,3]
//[-1,5,3,4,0]
//[]
public class L148SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public void printList(ListNode node){
            while( node != null ){
                System.out.print(node + "->");
                node = node.next;
            }
            System.out.println();
        }

        public String toString(){
            return "" + this.val;
        }
    }

    public static void main(String[] args) {
        new L148SortList().run();
    }

    public void run(){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        sortList(head);
    }

    public ListNode sortList(ListNode head) {

        if( head == null ) return head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                new Comparator<ListNode>(){
                    @Override
                    public int compare(ListNode node1, ListNode node2){
                        return node1.val - node2.val;
                    }
                }
        );

        head.printList(head);

        while( head != null ){
            ListNode node = new ListNode(head.val);
            pq.add(node);
            head = head.next;
        }

        ListNode start = head = pq.poll();

        while( !pq.isEmpty() ){
            head.next = pq.poll();
            head = head.next;
        }

        start.printList(start);

        return start;
    }

}
