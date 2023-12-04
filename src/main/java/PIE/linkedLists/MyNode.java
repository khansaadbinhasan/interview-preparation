package PIE.linkedLists;

public class MyNode {
    public int val;
    public MyNode next;

    public MyNode() {
    }

    public MyNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return val + ",";
    }
}
