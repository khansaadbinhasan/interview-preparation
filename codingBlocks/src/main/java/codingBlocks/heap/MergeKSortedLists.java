package codingBlocks.heap;

import java.util.*;

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists1(ListNode[] lists) {

        if( lists.length == 0 ) return null;
        if( lists.length == 1 ) return lists[0];

        List<ListNode> ll = new LinkedList<>(Arrays.asList(lists));

        int pointer = 0;

        while( pointer + 1 < ll.size() ){
            ll.add(merge(ll.get(pointer), ll.get(pointer+1)));
            pointer+=2;
        }

        return ll.get(ll.size()-1);
    }

    public ListNode merge(ListNode list1, ListNode list2) {

        ListNode pointer1 = list1;
        ListNode pointer2 = list2;

        ListNode list = null;


        if( pointer2 == null && pointer1 != null )
        {
            list = new ListNode(pointer1.val);
            pointer1 = pointer1.next;
        }

        if( pointer1 == null && pointer2 != null )
        {
            list = new ListNode(pointer2.val);
            pointer2 = pointer2.next;
        }

        ListNode head = list;

        if( pointer1 != null && pointer2 != null ){
            if( pointer1.val < pointer2.val )
            {
                list = new ListNode(pointer1.val);
                pointer1 = pointer1.next;
            }

            else
            {
                list = new ListNode(pointer2.val);
                pointer2 = pointer2.next;
            }

            head = list;

            while( pointer1 != null && pointer2 != null ){

                if( pointer1.val < pointer2.val )
                {
                    list.next = new ListNode(pointer1.val);
                    pointer1 = pointer1.next;
                }

                else
                {
                    list.next = new ListNode(pointer2.val);
                    pointer2 = pointer2.next;
                }

                list = list.next;
            }
        }

        while( pointer1 != null ){
            list.next = new ListNode(pointer1.val);
            pointer1 = pointer1.next;
            list = list.next;
        }

        while( pointer2 != null ){
            list.next = new ListNode(pointer2.val);
            pointer2 = pointer2.next;
            list = list.next;
        }

        return head;
    }


//    public ListNode mergeKLists(ListNode[] lists) {
//
//        if( lists.length == 0 ) return null;
//        if( lists.length == 1 ) return lists[0];
//
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<>(){
//            public int compare(ListNode o1, ListNode o2){
//                return o1.val - o2.val;
//            }
//        });
//
//        boolean allNull = true;
//
//        for (int i = 0; i < lists.length; i++) {
//            pq.offer(lists[i]);
//
//            if( lists[i] != null ) {
//                lists[i] = lists[i].next;
//                allNull = false;
//            }
//        }
//
//        ListNode head = pq.peek();
//        ListNode listPointer = head;
//
//        while( !pq.isEmpty() && listPointer != null ){
//            listPointer.next = pq.poll();
//            listPointer = listPointer.next;
//        }
//
//        while (!allNull){
//            for (int i = 0; i < lists.length; i++) {
//                pq.offer(lists[i]);
//
//                if( lists[i] != null ) {
//                    lists[i] = lists[i].next;
//                    allNull = false;
//                }
//            }
//
//            while( !pq.isEmpty() && listPointer != null ){
//                listPointer.next = pq.poll();
//                listPointer = listPointer.next;
//            }
//        }
//
//
//        return head;
//    }

}
