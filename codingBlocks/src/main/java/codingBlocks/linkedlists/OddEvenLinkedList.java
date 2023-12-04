package codingBlocks.linkedlists;

import java.util.Scanner;

public class OddEvenLinkedList {

    public class ListNode {
      int val;
      ListNode next;

      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        new OddEvenLinkedList().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ListNode head = null;

        for (int i = 0; i < N; i++) {
            head = insert(new ListNode(sc.nextInt()), head);
        }

        System.out.print("Original List: "); printLinkedList(head);
        oddEvenList(head);
        System.out.print("Modified List: "); printLinkedList(head);

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



    public ListNode oddEvenList(ListNode head) {

        if( head == null || head.next == null ) return head;

        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        ListNode evenPointer = head.next;

        while( pointer1 != null && pointer2 != null &&
                pointer1.next != null && pointer2.next != null ){

            pointer1.next = pointer1.next.next;
            pointer2.next = pointer2.next.next;

            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        if( pointer1.next == null || pointer2.next == null )
            pointer1.next = evenPointer;


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

}
