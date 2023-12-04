package leetcode.easy;

import java.util.*;

//["OrderedStream","insert","insert","insert","insert","insert"]
//[[5],[3,"ccccc"],[1,"aaaaa"],[2,"bbbbb"],[5,"eeeee"],[4,"ddddd"]]
public class L1656DesignOrderedStream {

    class OrderedStream {

        String[] arr;

        public OrderedStream(int n) {
            arr = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            idKey--;
            arr[idKey] = value;

            List<String> lst = new LinkedList<>();

            for( int i = 0; i < idKey; i++ ){
                if( arr[i] == null ) return lst;
            }

            for( int i = idKey; i < arr.length; i++ ){
                if( arr[i] == null ) return lst;
                lst.add(arr[i]);
            }

            return lst;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */

}
