package PIE.treesAndGraphs;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        new LowestCommonAncestor().run();
    }

    public void run(){

        MyTree myTree = new MyTree();

        MyTreeNode root = myTree.getDemoTreeLCA();

        System.out.println(findLowestCommonAncestor(root, 4, 14));

    }

    public int findLowestCommonAncestor(MyTreeNode root, int val1, int val2){

        if( root == null ) return -1;

        if( val1 < root.val && val2 < root.val )
            return findLowestCommonAncestor(root.left, val1, val2);

        if( val1 > root.val && val2 > root.val )
            return findLowestCommonAncestor(root.right, val1, val2);

        return root.val;
    }



}
