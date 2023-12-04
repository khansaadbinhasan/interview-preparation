package codingBlocks.linkedlists;

import java.util.Scanner;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        new CopyListWithRandomPointer().run();
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Node headCopied = null;
        Node[] nodesArr = new Node[N];
        int[] randomIndexArr = new int[N];

        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            int randomIndex = sc.nextInt();

            headCopied = insert(new Node(val), headCopied, nodesArr, i);
            randomIndexArr[i] = randomIndex;
        }

        headCopied = copyRandomList(headCopied, nodesArr, randomIndexArr);
        System.out.print("Copied List: "); printLinkedList(headCopied);
        System.out.print("Old List: "); printLinkedList(headCopied);
    }

    public Node insert(Node node, Node head, Node[] nodesArr, int index){
        if( head == null ){
            head = node;
            nodesArr[index] = node;
            return head;
        }

        Node pointer = head.next;

        if( pointer == null ) {
            head.next = node;
            nodesArr[index] = node;
            return head;
        }

        while( pointer.next != null ) {
            pointer = pointer.next;
            nodesArr[index] = node;
        }

        pointer.next = node;
        nodesArr[index] = node;

        return head;
    }

    public Node copyRandomList(Node head, Node[] nodesArr, int[] randomIndexArr) {

        Node pointer = head;
        int index = 0;

        while( pointer != null ){
            pointer.random = nodesArr[randomIndexArr[index]];
            pointer = pointer.next;
            index++;
        }

        return head;
    }

    //assumes that linkedlist is not empty
    public void printLinkedList(Node head){
        Node pointer = head.next;

        System.out.print("(" + head.val + "," + head.random.val + ") ");

        while( pointer.next != null ) {
            System.out.print("(" + pointer.val + "," + pointer.random.val + ") ");
            pointer = pointer.next;
        }

        System.out.print("(" + pointer.val + "," + pointer.random.val + ") ");

        System.out.println();
    }

}