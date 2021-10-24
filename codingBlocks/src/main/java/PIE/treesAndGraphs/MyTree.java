package PIE.treesAndGraphs;

public class MyTree {

    public MyTree(){

    }


    //     100
    //    /   \
    //   50   150
    //  / \   / \
    // 25 75 125 175
    //       /
    //      110
    public MyTreeNode getDemoTree(){

        MyTreeNode root = new MyTreeNode(100);

        MyTreeNode node2 = root.left = new MyTreeNode(50);
        MyTreeNode node3 = root.right = new MyTreeNode(150);
        MyTreeNode node4 = node2.left = new MyTreeNode(25);
        MyTreeNode node5 = node2.right = new MyTreeNode(75);
        MyTreeNode node6 = node3.left = new MyTreeNode(125);
        MyTreeNode node7 = node3.right = new MyTreeNode(175);
        MyTreeNode node8 = node6.left = new MyTreeNode(110);


        return root;
    }

    //     20
    //    /   \
    //   8    22
    //  / \
    // 4  12
    //    / \
    //   10 14
    public MyTreeNode getDemoTreeLCA(){

        MyTreeNode root = new MyTreeNode(20);

        MyTreeNode node2 = root.left = new MyTreeNode(8);
        MyTreeNode node3 = root.right = new MyTreeNode(22);
        MyTreeNode node4 = node2.left = new MyTreeNode(4);
        MyTreeNode node5 = node2.right = new MyTreeNode(12);
        MyTreeNode node6 = node5.left = new MyTreeNode(10);
        MyTreeNode node7 = node5.right = new MyTreeNode(14);

        return root;
    }

}
