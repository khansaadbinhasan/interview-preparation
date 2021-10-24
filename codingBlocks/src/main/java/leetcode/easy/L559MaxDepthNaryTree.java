package leetcode.easy;

import java.util.*;

//[1,null,3,2,4,null,5,6]
//[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//[]
//[1]
public class L559MaxDepthNaryTree {

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

    public int maxDepth(Node root) {

        if( root == null ) return 0;


        int max = 0;

        for( Node child: root.children ){
            max = Math.max(max,maxDepth(child));
        }

        return max + 1;

    }

}
