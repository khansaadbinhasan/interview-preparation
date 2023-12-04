package PIE.linkedLists;

public class MyLinkedList {
    public MyNode head;

    public MyLinkedList() {
        this.head = null;
    }

    public MyLinkedList(MyNode head) {
        this.head = head;
    }

    public MyNode getDemoLinkedList(){

        this.head = new MyNode(3);

        MyNode node1 = this.head;

        MyNode node2 = node1.next = new MyNode(2);
        MyNode node3 = node2.next = new MyNode(4);
        MyNode node4 = node3.next = new MyNode(6);
        node4.next = new MyNode(2);

        return head;
    }

    public MyNode getDemoCyclicLinkedList(){

        this.head = new MyNode(3);

        MyNode node1 = this.head;

        MyNode node2 = node1.next = new MyNode(2);
        MyNode node3 = node2.next = new MyNode(4);
        MyNode node4 = node3.next = new MyNode(6);
        MyNode node5 = node4.next = new MyNode(2);

        node5.next = node3;

        return head;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        MyNode myNode = head;

        while (myNode != null) {
            sb.append(myNode.toString());
            myNode = myNode.next;
        }

        if (sb.length() > 0) sb = sb.deleteCharAt(sb.length() - 1);

        return "[" + sb.toString().trim() + "]";
    }
}
