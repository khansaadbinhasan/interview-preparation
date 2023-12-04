package leetcode.easy;

import java.util.*;


//["Mary","John","Emma"]
//[180,165,170]
//["Alice","Bob","Bob"]
//[155,185,150]
//["Alice"]
//[155]
public class L2418SortPeople {

    public static void main(String[] args) {
        new L2418SortPeople().run();
    }

    public void run(){
        sortPeople(new String[]{"This", "That"}, new int[]{2,3});
    }

    public String[] sortPeople(String[] names, int[] heights) {

        PriorityQueue<NameHeights> priorityQueue = new PriorityQueue<NameHeights>(NameHeights::compareTo);

        for (int i = 0; i < names.length; i++) {
            priorityQueue.add(new NameHeights(names[i], heights[i]));
        }


        String[] sortedPeople = new String[names.length];

        int s = 0;

        while( !priorityQueue.isEmpty() ){
            sortedPeople[s++] = priorityQueue.poll().getName();
        }

        return sortedPeople;
    }




    class NameHeights{
        String name;
        int height;


        public NameHeights(String name, int height){
            this.name = name;
            this.height = height;
        }

        public String getName(){
            return name;
        }

        public int getHeight(){
            return height;
        }

        //        @Override
        public int compareTo(NameHeights nameHeights){
            return Integer.compare(nameHeights.getHeight(), this.height);
        }

    }
}


