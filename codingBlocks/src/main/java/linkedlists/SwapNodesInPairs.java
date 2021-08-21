package linkedlists;

import java.util.Scanner;

public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        new SwapNodesInPairs().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ListNode head = null;

        for (int i = 0; i < N; i++) {
            head = insert(new ListNode(sc.nextInt()), head);
        }

        printLinkedList(head);
        head = swapPairs(head);
        printLinkedList(head);
    }

    public ListNode insert(ListNode node, ListNode head){

        if( head == null ){
            head = node;
            return head;
        }

        ListNode pointer = head.next;

        if( pointer == null ) {
            head.next = node;
            return head;
        }

        while( pointer.next != null ) pointer = pointer.next;

        pointer.next = node;

        return head;
    }

    //assumes that linkedlist is not empty
    public void printLinkedList(ListNode head){
        ListNode pointer = head.next;

        System.out.print(head.val + " -> ");

        while( pointer.next != null ) {
            System.out.print(pointer.val + " -> ");
            pointer = pointer.next;
        }

        System.out.print(pointer.val);

        System.out.println();
    }

    public ListNode swapPairs(ListNode head) {

        if( head == null || head.next == null ) return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;
        head = p2;

        if( p2.next == null ) {
            p2.next = p1;
            p1.next = null;
            return head;
        }

        ListNode p3 = p2.next;



        while( p3 != null && p3.next != null ){
            p1.next = p3.next;
            p2.next = p1;
            p1 = p3;
            p2 = p1.next;
            p3 = p2.next;
        }


        if( p3 == null ){
            p1.next = null;
            p2.next = p1;
        }

        else if( p3.next == null ){
            p2.next = p1;
            p1.next = p3;
        }

        return head;
    }
}
