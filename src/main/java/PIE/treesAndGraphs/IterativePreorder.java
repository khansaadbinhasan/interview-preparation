package PIE.treesAndGraphs;

import java.util.*;

public class IterativePreorder {

    List<MyTreeNode> preorderLst = new LinkedList<>();
    Stack<MyTreeNode> stack = new Stack<>();

    public static void main(String[] args) {
        new IterativePreorder().run();
    }

    public void run(){

        MyTree myTree = new MyTree();

        MyTreeNode root = myTree.getDemoTree();

        iterativePreorder(root);
//        iterativePreorder(new MyTreeNode(1));

        System.out.println(preorderLst);
    }

    public MyTreeNode iterativePreorder(MyTreeNode rooted){

        MyTreeNode root = rooted;

        if( root == null ) return null;

        while ( root != null ){
            while( root != null ){
                preorderLst.add(root);
                stack.push(root);
                root = root.left;
            }

            if( !stack.isEmpty() )
                root = stack.pop();

            while( !stack.isEmpty() && root != null && root.right == null ){
                root = stack.pop();
            }

            if( root != null ) root = root.right;
        }


        return rooted;
    }

}
