package leetcode.easy;

//[3,2,0,-4]
//1
//[1,2]
//0
//[1]
//-1
//[]
//-1
public class L141LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while( slowPointer != null && fastPointer != null && fastPointer.next != null ){

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if( slowPointer == fastPointer ) return true;

        }

        return false;

    }

}
