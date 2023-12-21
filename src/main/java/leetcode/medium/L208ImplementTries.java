package leetcode.medium;

import java.util.*;

public class L208ImplementTries {

    //insert saad
    //insert self
    //insert salt
    //search s
    //search gru
    //search salt
    //startsWith s

    Map<Character, List<String>> map = new HashMap<>();//{s->[saad, self,salt]}

    public L208ImplementTries() {

    }

    public void insert(String word) {
        char c = word.charAt(0);//s
        List<String> lst = new LinkedList<>();
        if( !map.containsKey(c) ) map.put( c, lst );

        lst = map.get(c);
        lst.add(word);
    }

    public boolean search(String word) {
        char c = word.charAt(0);//s
        if( map.containsKey(c) ){
            for( String w: map.get(c) ){//saad, self, salt
                if( w.equals(word) ) return true;
            }
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        char c = prefix.charAt(0);//s
        if( map.containsKey(c) ){
            for( String w: map.get(c) ){
                if( w.startsWith(prefix) ) return true;
            }
        }

        return false;
    }



    class Trie {


        //insert saad
        //insert self
        //insert salt
        //search s
        //search gru
        //search salt
        //startsWith s
        public class TreeNode {
            public char val;
            public TreeNode[] childs;
            public boolean isEnd;

            public TreeNode(){
                this('Z');
            }

            public TreeNode(char value){
                this.val = value;
                this.childs = new TreeNode[26];
                for( int i = 0; i < childs.length; i++ ){
                    childs[i] = null;
                }
                this.isEnd = false;
            }
        }


        TreeNode root;

        public Trie(){
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode node = root;
            for( char c: word.toCharArray() ){
                if( node.childs[c-'a'] == null ) {
                    node.childs[c-'a'] = new TreeNode(c);
                }
                node = node.childs[c-'a'];
            }

            node.isEnd = true;
        }

        public boolean search(String word) {
            TreeNode node = root;
            for( char c: word.toCharArray() ){
                if( node == null ) return false;
                if( node.childs[c-'a'] != null && node.childs[c-'a'].val == c ) {
                    node = node.childs[c-'a'];
                }
                else {
                    return false;
                }
            }

            return node.isEnd;
        }

        public boolean startsWith(String word) {
            TreeNode node = root;
            for( char c: word.toCharArray() ){
                if( node == null ) return false;
                if( node.childs[c-'a'] != null && node.childs[c-'a'].val == c ) {
                    node = node.childs[c-'a'];
                }
                else {
                    return false;
                }
            }

            return true;
        }
    }


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
