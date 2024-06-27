package codingBlocks.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeExperiment {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) {
        new TreeExperiment().run();
    }

    int sum = 0;
    int count = 0;

    List<Integer> inOrderList = new ArrayList<>();
    List<Integer> inOrderStarList = new ArrayList<>();
    
    public void run(){

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

//        inOrderCount(root);
//        System.out.println(count);

//        List<Integer> list = new ArrayList<>();
//        System.out.println("inorder:");
//        inOrder(root.left, list);
//        System.out.println();

//        inOrder(root.right, list);


        System.out.println(isContain(root, 14));


//        System.out.println("inorder:");
//        inOrder(root, new ArrayList<>());
//        System.out.println();
//
//        System.out.println("preOrder:");
//        preOrder(root);
//        System.out.println();
//
//        System.out.println("postOrder:");
//        postOrder(root);
//        System.out.println();


//        System.out.println(inOrderList);
//        System.out.println(inOrderStarList);


//
//        inOrderSum(root);
//
//        System.out.println(this.sum);


//        Node root = createTree();
//
//        inOrder(root);
//        System.out.println();
//
//        preOrder(root);
//        System.out.println();
//
//        postOrder(root);
//        System.out.println();
    }

    public boolean isContain(Node root, int value){

        if( root == null ) return false;

        return  root.val == value ||
                isContain(root.left, value) ||
                isContain(root.right, value);
    }


    private void inOrderCount(Node root) {

        if( root == null ) return;

        inOrderCount(root.left);
        count++;
        inOrderCount(root.right);
    }

    public void inOrderSum(Node root) {

        if( root == null ) return;

        inOrderSum(root.left);
        this.sum += root.val;
        inOrderSum(root.right);

    }

    public Node createTree(){

        Node root = null;

        System.out.println("Enter data: ");

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        if( data == -1 ) return null;

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;
    }

    public void inOrder(Node root, List<Integer> lst){
        if( root == null ) return;

        inOrder(root.left, lst);
        System.out.print(root.val + " ");
        lst.add(root.val);
        inOrder(root.right, lst);
    }

//    public void inOrderStar(Node root){
//        if( root == null ) return;
//
//        inOrder(root.right);
//        System.out.print(root.val + " ");
//        inOrderStarList.add(root.val);
//        inOrder(root.left);
//    }

    public void preOrder(Node root){
        if( root == null ) return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if( root == null ) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public Node insert(Node root, Node node){

        if( root == null ) root = node;

        return root;

    }



}

