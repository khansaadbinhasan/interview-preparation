package codingBlocks.linkedlists;

import java.util.Scanner;

public class KthFromTheEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        new KthFromTheEnd().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int n = sc.nextInt();

        ListNode head = null;

        for (int i = 0; i < N; i++) {
            head = insert(new ListNode(sc.nextInt()), head);
        }

        head = removeNthFromEnd(head, n);
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

        System.out.print(head.val + " ");

        while( pointer.next != null ) {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }

        System.out.print(pointer.val + " ");

        System.out.println();
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {

        if( head == null ) return null;

        int numElems = 0;
        ListNode pointer = head;

        while( pointer != null ) {
            numElems++;
            pointer = pointer.next;
        }

        int index = numElems - n;
        int i = 0;


        if( index == 0 ) {
            head = head.next;
            return head;
        }

        pointer = head;
        ListNode prevPointer = head;

        while( i != index ){
            prevPointer = pointer;
            pointer = pointer.next;
            i++;
        }

        prevPointer.next = pointer.next;

        return head;

    }
}
