package leetcode.easy;

//[18,6,10,3]
//[7]
//[18,6,10,3,8]
//[1,2,3,4,5,6,7]
public class L2807InsertElem {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode newHead = head;

        while( newHead != null && newHead.next != null ){
            ListNode node = new ListNode(gcd(newHead.val, newHead.next.val));
            node.next = newHead.next;
            newHead.next = node;
            newHead = node.next;
        }

        return head;
    }

    public int gcd(int a, int b){
        return b == 0 ? a: gcd(b,a%b);
    }
}
