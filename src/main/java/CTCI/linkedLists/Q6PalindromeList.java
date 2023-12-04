package CTCI.linkedLists;

import java.util.Stack;

//[1,2,2,1]
//[1,2]
//[1]
//[1,2,3,4,5]
//[1,2,3,2,1]
public class Q6PalindromeList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode node = head;

        int count = 0;

        while( node != null ){
            stack.push(node.val);

            node = node.next;
            count++;
        }

        for( int i = 0; i < count / 2; i++ ){
            if( stack.peek() != head.val ) return false;
            head = head.next;

            stack.pop();
        }

        return true;
    }

    public boolean isPalindromeII(ListNode head) {

        ListNode newList = copyList(head);
        ListNode headRev = reverse(newList);

        return isEqual(head, headRev);
    }

    public ListNode copyList(ListNode head){

        ListNode newHead = new ListNode(head.val);

        ListNode node = head;
        ListNode newNode = newHead;

        while( node != null ){

            node = node.next;

            if( node == null ) break;

            newNode = newNode.next = new ListNode(node.val);
        }

        return newHead;
    }


    public ListNode reverse(ListNode head){

        if( head == null || head.next == null ) return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;

        ListNode pointer = head;

        while( pointer.next != null ) {
            pointer = pointer.next;
        }

        p1.next = null;

        while( p2 != null ){
            p2.next = p1;
            p1 = p2;
            p2 = p3;

            if( p3 != null ) p3 = p3.next;
        }

        return p1;

    }

    public boolean isEqual(ListNode head1, ListNode head2){
        ListNode p1 = head1;
        ListNode p2 = head2;

        while( p1 != null && p2 != null ){
            if( p1.val != p2.val ) return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return (p1 == null) && (p2 == null);
    }


}
