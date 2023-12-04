package codingBlocks.arrays;

import java.util.*;

public class MyHashset {

    private final int MAX_VALUE = 100000;
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> hashset;


    public MyHashset(){
        this.hashset = new ArrayList<>(ARRAY_SIZE);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            this.hashset.add(null);
        }
    }

    public void add(int key){

        int index = key % ARRAY_SIZE;

        List<Integer> childList = hashset.get(index);

        if( childList == null ){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            hashset.set(index, list);
        }

        else{
            if( !childList.contains(key) ){
                childList.add(key);
            }
        }
    }

    public void remove(int key){
        int index = key % ARRAY_SIZE;

        List<Integer> childList = hashset.get(index);

        if(childList != null){
                childList.remove(Integer.valueOf(key));
        }
    }

    //returns true if set contains specified key
    public boolean contains(int key){
        int index = key % ARRAY_SIZE;

        List<Integer> childList = hashset.get(index);

        return ( childList != null && childList.contains(Integer.valueOf(key)));
    }

}
