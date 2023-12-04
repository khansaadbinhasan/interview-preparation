package leetcode.medium;

import java.util.*;

//"ababcbacadefegdehijhklij"
//"eccbbbbdec"
//"a"
//"adjfklsdhajkfhadsjkfhjkdashfjkasdhfjhadsjkfhsjkdahfjkdsfhakshfkldashfjkasdhfk"
//"aaaaaaaa"
//"ababjkfhdsjkfhsjkahfdjkahjdkfhsjkdha"
//"qiejxqfnqceocmy"
public class L763PartitionLabels {

    public static void main(String[] args) {
        new L763PartitionLabels().run();
    }

    public void run(){
        System.out.println(partitionLabels("qiejxqfnqceocmy"));
    }

    public List<Integer> partitionLabels(String s) {
        //create a array with given char and its last index
        // a --> 8
        //Create a set isDone --> Contains all the elements that are less than given index array else remove
        //once empty start creating new string


        List<Integer> partitions = new LinkedList<>();
        int[] indexArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            indexArr[s.charAt(i)-'a'] = i;
        }

        Set<Character> set = new HashSet<>();

        for( int i = 0; i < s.length(); i++ ){
            int oldI = i;
            int aIndex = indexArr[s.charAt(i)-'a'];

            while( i <= aIndex ){
                set.add(s.charAt(i));

                if( i == indexArr[s.charAt(i)-'a'] ){
                    set.remove(s.charAt(i));
                }

                while ( i == aIndex ){
                    if( !set.isEmpty() && (i+1 < s.length()) )  set.add(s.charAt(i+1));

                    while(i < s.length() && !set.isEmpty()){
                        if( set.contains(s.charAt(i)) && indexArr[s.charAt(i)-'a'] > aIndex ){
                            aIndex = indexArr[s.charAt(i)-'a'];
                            set.remove(s.charAt(i));
                            i++;
                            break;
                        }

                        i++;
                    }

                    if( set.isEmpty() ) {
                        partitions.add(aIndex+1 - oldI);
                        i = aIndex;
                        break;
                    }

                    i--;
                }

                i++;
            }

            i--;
        }

        return partitions;
    }

}
