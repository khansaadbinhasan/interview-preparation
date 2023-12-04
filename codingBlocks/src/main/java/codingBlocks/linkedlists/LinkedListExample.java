package codingBlocks.linkedlists;

public class LinkedListExample {
    class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }
    }

    private static Node head = null;

    public static void main(String[] args) {
        new LinkedListExample().run();
    }

    public void run(){

        LinkedListExample l = new LinkedListExample();

        l.insert(new Node(1));
        l.insert(new Node(2));
        l.insert(new Node(3));
        l.insert(new Node(4));
        l.insert(new Node(5));
        l.insert(new Node(6));

        l.printLinkedList();

        l.delete(2);l.printLinkedList();
        l.delete(6);l.printLinkedList();
        l.delete(1);l.printLinkedList();
        l.delete(2);l.printLinkedList();

        System.out.println(l.find(3).val);
        System.out.println(countNodes());
    }

    public void insert(Node node){

        if( head == null ){
            head = node;
            return;
        }

        Node pointer = head.next;

        if( pointer == null ) {
            head.next = node;
            return;
        }

        while( pointer.next != null ) pointer = pointer.next;

        pointer.next = node;
    }

    public void delete(int val){

        if( head == null ) return;
        if( head.next == null && head.val != val ) return;

        if( head.val == val ){
            head = head.next;
            return;
        }

        Node currPointer = head.next;
        Node prevPointer = head;

        while( currPointer != null ){
            if( currPointer.val == val ){
                prevPointer.next = currPointer.next;
                currPointer.next = null;
                break;
            }

            prevPointer = currPointer;
            currPointer = currPointer.next;
        }
    }

    public Node find(int val){
        Node currPointer = head;

        while( currPointer != null ){
            if( currPointer.val == val ) return currPointer;

            currPointer = currPointer.next;
        }

        return null;
    }

    public static int countNodes(){

        Node currPointer = head;
        int count = 0;

        while( currPointer != null ){
            currPointer = currPointer.next;
            count++;
        }

        return count;
    }

    //assumes that linkedlist is not empty
    public void printLinkedList(){
        Node pointer = head.next;

        System.out.print(head.val + " ");

        while( pointer.next != null ) {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }

        System.out.print(pointer.val + " ");

        System.out.println();
    }
}
