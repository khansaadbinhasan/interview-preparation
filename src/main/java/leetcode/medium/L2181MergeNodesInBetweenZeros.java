package leetcode.medium;

//[0,3,1,0,4,5,2,0]
//[0,1,0,3,0,2,2,0]
//[0,1,0]
//[0,1,2,3,4,0]
//[0,1,2,3,3,1,3,4,0]
//[0,1,2,0,3,3,0,1,3,4,0]
public class L2181MergeNodesInBetweenZeros {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeNodes(ListNode head) {

        ListNode originalHead = head;

        while( originalHead.next != null ){
            ListNode origin = originalHead;
            ListNode currNode = originalHead;

            if( origin.val == 0 ){
                currNode = currNode.next;
                int sum = 0;

                while( currNode.val != 0  ){
                    sum += currNode.val;
                    currNode = currNode.next;
                }

                origin.val = sum;
                origin.next = currNode;

                if( currNode.next == null ){
                    origin.next = null;
                }
            }

            originalHead = currNode;
        }

        return head;
    }

}
