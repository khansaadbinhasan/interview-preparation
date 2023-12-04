package leetcode.easy;

import java.util.*;


//8
//[4,1,8,4,5]
//[5,6,1,8,4,5]
//2
//3
//2
//[1,9,1,2,4]
//[3,2,4]
//3
//1
//0
//[2,6,4]
//[1,5]
//3
//2

public class L160IntersectionOfLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode node1 = headA;
        ListNode node2 = headB;

        Set<ListNode> setNode = new HashSet<>();

        while( node1 != null ){
            setNode.add(node1);
            node1 = node1.next;
        }

        while( node2 != null ){
            if( setNode.contains(node2) ) return node2;

            setNode.add(node2);
            node2 = node2.next;
        }

        return null;

    }
}
