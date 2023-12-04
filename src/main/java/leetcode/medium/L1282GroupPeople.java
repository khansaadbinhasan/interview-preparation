package leetcode.medium;

import java.util.*;

//[3,3,3,3,3,1,3]
//[2,1,3,3,3,2]
//[1]
//[1,1,1,1]
//[2,2,2,2]
public class L1282GroupPeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new LinkedList<>();

        int max = groupSizes[0];

        for( int i = 1; i < groupSizes.length; i++ ){
            max = Math.max(max, groupSizes[i]);
        }

        for( int i = 0; i <= max; i++ ){
            groups.add(new LinkedList<>());
        }

        for( int i = 0; i < groupSizes.length; i++ ){
            groups.get(groupSizes[i]-1).add(i);
        }

        int size = groups.size();
        for( int i = 0; i < groups.size(); i++ ){
            if( !groups.get(i).isEmpty() ) {
                int k = i+1;
                for (int j = 0; j <= groups.get(i).size()-k; j+=k) {
                    groups.add(groups.get(i).subList(j,j+k));
                }
            }
        }

        for( int i = 0; i < size; i++ ){
            groups.remove(0);
        }

        return groups;
    }

}
