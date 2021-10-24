package PIE.linkedLists;

public class IsCyclicLinkedList {

    public static void main(String[] args) {
        new IsCyclicLinkedList().run();
    }

    public void run(){

        MyLinkedList mLL = new MyLinkedList();

        MyNode myAcyclicLL = mLL.getDemoLinkedList();
        MyNode myCyclicLL = mLL.getDemoCyclicLinkedList();

//        System.out.println(isLLCyclic(myAcyclicLL));
//        System.out.println(isLLCyclic(myCyclicLL));

        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);

//        node1.next = node2;
//        node2.next = node1;

        System.out.println(isLLCyclic(node1));
//        System.out.println(isLLCyclic(null));

    }

    public boolean isLLCyclic(MyNode head){

        if( head == null ) return false;

        MyNode slow = head;
        MyNode fast = head;


        while( fast != null ){

            slow = slow.next;

            if( slow == null ) return false;
            if( fast.next == null ) return false;

            fast = fast.next.next;

            if( fast == slow ) return true;
        }

        return false;
    }

}
