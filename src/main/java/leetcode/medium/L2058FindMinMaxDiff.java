package leetcode.medium;

import java.util.*;

//[3,1]
//[5,3,1,2,5,1,2]
//[1,3,2,2,3,2,2,2,7]
//[1,9]
//[1,2,3,4,5]
//[1,2,3,4,5,5,6,4,3,2]
//[1,2,3,2,1,3]
public class L2058FindMinMaxDiff {

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        List<Integer> criticalNodes = new LinkedList<>();

        ListNode prev = head;
        head = head.next;
        int i = 1;

        int minDist = Integer.MAX_VALUE;

        while( head != null && head.next != null ){
            if( (head.val > prev.val && head.val > head.next.val) || (head.val < prev.val && head.val < head.next.val) ) {
                if( criticalNodes.size() > 0 )
                    minDist = Math.min(minDist, i-criticalNodes.get(criticalNodes.size()-1));
                criticalNodes.add(i);
            }

            prev = head;
            head = head.next;
            i++;
        }

        if( criticalNodes.size() < 2 ){
            return new int[]{-1,-1};
        }

        int maxDist = criticalNodes.get(criticalNodes.size()-1)-criticalNodes.get(0);

        return new int[]{minDist, maxDist};
    }
}
