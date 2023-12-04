package PIE.linkedLists;

public class ListFlattening {




}


class UltraNode{

    int val;

    UltraNode next;
    UltraNode prev;
    UltraNode child;

    public UltraNode(){

    }

    public UltraNode(int val){
        this.val = val;

        this.next = null;
        this.prev = null;
        this.child = null;
    }
}

class UltraLinkedList{

    public UltraNode getExampleUltraLinkedList(){

        UltraNode head = new UltraNode(5);

        UltraNode node1 = new UltraNode(33);
        UltraNode node2 = new UltraNode(17);
        UltraNode node3 = new UltraNode(2);
        UltraNode node4 = new UltraNode(1);
        UltraNode node5 = new UltraNode(6);
        UltraNode node6 = new UltraNode(25);
        UltraNode node7 = new UltraNode(6);
        UltraNode node8 = new UltraNode(2);
        UltraNode node9 = new UltraNode(7);
        UltraNode node10 = new UltraNode(8);
        UltraNode node11 = new UltraNode(9);
        UltraNode node12 = new UltraNode(12);
        UltraNode node13 = new UltraNode(5);
        UltraNode node14 = new UltraNode(7);
        UltraNode node15 = new UltraNode(21);
        UltraNode node16 = new UltraNode(3);

        UltraNode tail = node5;

        head.next = node1;
        head.child = node5;

        node1.next = node3;
        node1.prev = head;

        node2.next = node6;

        node3.next = node4;
        node3.prev = node1;

        node4.next = node5;
        node4.prev = node3;
        node4.child = node8;

        node5.prev = node4;

//        node7.next




        return head;
    }

}