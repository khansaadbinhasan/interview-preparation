package CTCI.ch2linkedLists;


//[2,4,3]
//[5,6,4]
//[0]
//[0]
//[9,9,9,9,9,9,9]
//[9,9,9,9]
//[5,6]
//[5,4,9]
public class Q5SumLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public void printList(ListNode node){
            while( node != null ) {
                System.out.print(node.val + "->");
                node = node.next;
            }
            System.out.println();
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        int carry = 0;

        ListNode p1 = l1;
        ListNode p2 = l2;

        if( head == null ) {
            int sum = p1.val + p2.val + carry;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            head = new ListNode(sum);
        }

        ListNode pointer = head;

        while( p1.next != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next;

            int sum = p1.val + p2.val + carry;

            carry = 0;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }

        while( p1.next != null ){
            p1 = p1.next;

            int sum = p1.val + carry;

            carry = 0;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }


        while( p2.next != null ){
            p2 = p2.next;

            int sum = p2.val + carry;

            carry = 0;

            if( sum >= 10 ) {
                sum = sum % 10;
                carry = 1;
            }

            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }

        if( carry == 1 ){
            pointer.next = new ListNode(1);
            pointer = pointer.next;
        }

        return head;

    }


    public static void main(String[] args) {
        new Q5SumLists().run();
    }

    public void run(){
        //617
        //295
        //1308
        //912
        ListNode n1 = new ListNode(6);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(7);

        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(5);

        System.out.println(sumLists(n1, n2));

        //6177
        //29
        //7808
        //6206
        n1 = new ListNode(6);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(7);
        n1.next.next.next = new ListNode(7);

        n2 = new ListNode(2);
        n2.next = new ListNode(9);

        System.out.println(sumLists(n1, n2));
    }

    public String sumLists(ListNode n1, ListNode n2){
        StringBuilder sum = new StringBuilder();

//        n1.printList(n1);
//        System.out.println();
//        n1.printList(n2);
//        System.out.println();

        n1 = reverseList(n1);
        n2 = reverseList(n2);

//        n1.printList(n1);
//        System.out.println();
//        n1.printList(n2);
//        System.out.println();

        ListNode p1 = n1;
        ListNode p2 = n2;

        int carry = 0;

        while( p1 != null && p2 != null ){
            int currSum = p1.val + p2.val + carry;

            carry = 0;

            if( currSum >= 10 ) {
                carry = currSum / 10;
                currSum = currSum % 10;
            }

            sum.append(currSum);
            p1 = p1.next;
            p2 = p2.next;
        }

        while( p1 != null ){
            int currSum = p1.val + carry;

            carry = 0;

            if( currSum >= 10 ) {
                carry = currSum / 10;
                currSum = currSum % 10;
            }

            sum.append(currSum);
            p1 = p1.next;
        }

        while( p2 != null ){
            int currSum = p2.val + carry;

            carry = 0;

            if( currSum >= 10 ) {
                carry = currSum / 10;
                currSum = currSum % 10;
            }

            sum.append(currSum);
            p2 = p2.next;
        }

        if( carry > 0 ) sum.append(carry);

        return sum.reverse().toString();
    }

    //6 <- 1 <- 7 <- 5  8
    public ListNode reverseList(ListNode n){
        if( n == null || n.next == null ) return n;

        ListNode head = n;//5
        ListNode node1 = n.next;//8
        ListNode node2 = node1.next;//null

        head.next = null;

        while( node2 != null ){
            node1.next = head;
            head = node1;
            node1 = node2;
            node2 = node2.next;
        }

        node1.next = head;

        return node1;
    }

}
