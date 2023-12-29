package leetcode.hard;

import java.util.*;

//[[1,4,5],[1,3,4],[2,6]]
//[]
//[[]]
//[[-2,-1,-1,-1],[]]
public class L23MergeKSortedLists {

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if( lists.length == 0 ) return null;
        if( lists.length == 1 ) return lists[0];

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if( lists[i] != null ) {
                pq.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode head = pq.poll();
        ListNode listPointer = head;

        if( listPointer != null && listPointer.next != null ) pq.offer(listPointer.next);

        while (listPointer != null && !pq.isEmpty()){
            listPointer.next = pq.poll();
            listPointer = listPointer.next;

            if( listPointer.next != null ) pq.offer(listPointer.next);
        }


        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists) {

        if( lists.length == 0 ) return null;
        if( lists.length == 1 ) return lists[0];

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            while( lists[i] != null ) {
                pq.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode head = pq.poll();
        ListNode listPointer = head;

        while (listPointer != null && !pq.isEmpty()){
            listPointer.next = pq.poll();
            listPointer = listPointer.next;
        }


        return head;
    }


}
