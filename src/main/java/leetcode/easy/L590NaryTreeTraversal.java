package leetcode.easy;

import java.util.*;

//[1,null,3,2,4,null,5,6]
//[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//[]
//[1]
//[1,null,2]

public class L590NaryTreeTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> lst = new LinkedList<>();

    public List<Integer> postorder(Node root) {

        if( root == null ) return lst;

        for(Node child: root.children ){
            postorder(child);
        }

        lst.add(root.val);

        return lst;
    }

}
