package CTCI.ch2linkedLists;


//[1,4,3,2,5,2]
//3
//[2,1]
//2
//[1,2,3,5,7,9,1,2,3,11,12]
//5
//[8,9,1,2,3,5,7,9,1,2,3,11,12]
//5
//[3,5,8,5,10,2,1]
//5
public class Q4PartitionLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public ListNode partition(ListNode head, int x) {

        if( head == null ) return null;

        if( head.val >= x ){

            ListNode node1 = head;

            while( node1.next != null && node1.next.val >= x ) node1 = node1.next;

            if( node1.next != null ){
                ListNode node2 = node1.next;

                while( node2.next != null && node2.next.val < x )
                    node2 = node2.next;

                ListNode oldHead = head;

                head = node1.next;
                node1.next = node2.next;
                node2.next = oldHead;
            }
        }


        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while( pointer1 != null ){

            while( pointer1.next != null && pointer1.next.val < x ){
                pointer1 = pointer1.next;
            }

            if( pointer1.next == null ) break;

            if( head.val < x )
                pointer2 = pointer1.next;

            while( pointer2.next != null && pointer2.next.val >= x ){
                pointer2 = pointer2.next;
            }

            if( pointer2.next == null ) break;

            ListNode pointer3 = pointer2.next;

            while( pointer3.next != null && pointer3.next.val < x ){
                pointer3 = pointer3.next;
            }

            if( pointer3 == null ) break;

            ListNode pointer4 = pointer1.next;
            ListNode pointer5 = pointer3.next;

            pointer1.next = pointer2.next;
            pointer2.next = pointer5;
            pointer3.next = pointer4;

            pointer1 = pointer3;
        }

        return head;
    }

    //3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
    //3 -> 1 -> 2 -> 5 -> 10 -> 5 -> 8
    public void partitionLL(ListNode head, int partition){
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while( pointer1 != null && pointer2 != null ){
            while( pointer1 != null && pointer1.val < partition ) pointer1 = pointer1.next;
            pointer2 = pointer1;
            while( pointer2 != null && pointer2.val >= partition ) pointer2 = pointer2.next;

            if( pointer1 == null || pointer2 == null ) return;

            int temp = pointer1.val;
            pointer1.val = pointer2.val;
            pointer2.val = temp;

            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
    }

    public static void main(String[] args) {
        new Q4PartitionLinkedList().run();
    }

    public void run(){
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        partitionLL(head, 5);

        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println();
    }


}
