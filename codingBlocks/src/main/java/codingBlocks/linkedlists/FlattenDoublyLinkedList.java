package codingBlocks.linkedlists;

import java.util.Scanner;

public class FlattenDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val){
            this.val = val;
        }
    };

    public static void main(String[] args) {
        new FlattenDoublyLinkedList().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Node head = null;

        for (int i = 0; i < N; i++) {
            head = insert(new Node(sc.nextInt()), head);
        }

        flatten(head);
        printLinkedList(head);
    }

    public Node insert(Node node, Node head){

        if( head == null ){
            head = node;
            return head;
        }

        Node pointer = head.next;

        if( pointer == null ) {
            head.next = node;
            return head;
        }

        while( pointer.next != null ) pointer = pointer.next;

        pointer.next = node;
        node.prev = pointer;

        return head;
    }

    public Node flatten(Node head) {

        if( head == null ) return head;

        Node pointer = head;

        while( pointer != null ){

            if( pointer.child != null ){
                Node pointerNext = pointer.next;

                pointer.next = pointer.child;
                pointer.child = null;

                Node newHead = flatten(pointer.next);

                newHead.prev = pointer;

                Node newPointer = newHead;

                while( newPointer.next != null ) newPointer = newPointer.next;

                if( pointerNext != null ) pointerNext.prev = newPointer;

                newPointer.next = pointerNext;
            }

            pointer = pointer.next;
        }

        printLinkedList(head);

        return head;
    }

    public void printLinkedList(Node head){

        Node pointer = head;

        while( pointer.next != null ) pointer = pointer.next;

        while(pointer != head ) {
            System.out.print(pointer.val + " ");
            pointer = pointer.prev;
        }

    }


}
