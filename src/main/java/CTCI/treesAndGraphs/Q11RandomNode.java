package CTCI.treesAndGraphs;

import java.util.Random;

public class Q11RandomNode {



}


class TreeNode{
    public int val;

    public TreeNode left;
    public TreeNode right;

    private int size = 0;

    public TreeNode(int val){
        this.val = val;
        this.size = 1;
    }

    public int size() {
        return this.size;
    }

    public int val(){
        return this.val;
    }

    public void insertInorder(int val){
        if( val <= this.val ) {
            if( left == null ) left = new TreeNode(val);
            else left.insertInorder(val);
        }

        else {
            if( right == null ) right = new TreeNode(val);
            else right.insertInorder(val);
        }

        size++;
    }

    public TreeNode find(int val){
        if( val == this.val ) return this;
        else if( val < this.val ) return left != null? left.find(val): null;
        else return right != null? right.find(val): null;
    }

    public TreeNode getRandomNode(){
        int leftSize = left == null ? 0: left.size();

        Random random = new Random();

        int index = random.nextInt(size);

        if( index < leftSize ) return left.getRandomNode();
        else if( index == leftSize ) return this;
        else return right.getRandomNode();
    }

    public TreeNode getIthNode(int i){
        int leftSize = left == null? 0: left.size();

        if( i < leftSize ) return left.getIthNode(i);
        else if( i == leftSize ) return this;
        else return right.getIthNode(i-(leftSize+1));
    }
}

class Tree{
    TreeNode root = null;

    public void insertInorder(int val){
        if( root == null ) root = new TreeNode(val);
        else root.insertInorder(val);
    }

    public int size(){
        return root == null? 0: root.size();
    }

    public TreeNode getRandomNode(){
        if( root == null ) return null;

        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i)   ;
    }
}
