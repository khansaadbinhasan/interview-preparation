package leetcode.easy;

//[1,2,2,1]
//[1,2]
//[1]
//[0]
//[1,2,3,4,5,6]
//[1,2,3,4,5,6,7,6,5,4,3,2,1]
//[1,2,3,4,5,6,7,7,6,5,4,3,2,1]
//[1]
//[1,1,1,1,4,5,6,7,1,1,1,1]

import java.util.*;

public class L234PalindromLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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


}
