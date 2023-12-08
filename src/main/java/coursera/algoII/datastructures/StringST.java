package coursera.algoII.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class StringST<Value> {

    private Node root;
    private int R;

    public StringST(){

    }

    private class Node{
        private Value val;
        private char c;
        private Node[] next;
    }


    public void put( String key, Value val ) {

    }

    public Value get( String key ){
        return null;
    }

    public void delete(String key){

    }

    public Iterable<String> keys(){
        Queue<String> queue = new LinkedList<>();
        collect(root, "", queue);

        return queue;
    }

    public void collect( Node x, String prefix, Queue<String> q ){
        if( x == null ) return;
        if( x.val != null ) q.add(prefix);

        for( char c = 0; c < R; c++ ){
            collect(x.next[c], prefix+c, q);
        }
    }

    public Iterable<String> keysWithPrefix(String prefix){
        Queue<String> queue = new LinkedList<>();

//        Node x = get(root, prefix, 0);
//        collect(x, prefix, queue);

        return queue;
    }

    public Iterable<String> keysThatMatch(String s){
        return null;
    }

    public String longestPrefixOf(String s){
        return "";
    }


}
