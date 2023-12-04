package PIE.treesAndGraphs;

public class MyTreeNode {

    int val;

    MyTreeNode left;
    MyTreeNode right;

    public MyTreeNode(){

    }

    public MyTreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}
