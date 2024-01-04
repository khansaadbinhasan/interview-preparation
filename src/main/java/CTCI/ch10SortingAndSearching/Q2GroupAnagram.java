package CTCI.ch10SortingAndSearching;

import java.util.*;

public class Q2GroupAnagram {

    public static void main(String[] args) {
        new Q2GroupAnagram().run();
    }

    public void run(){
        String[] arr = new String[]{"abb", "abc", "cba", "bba", "cca", "abc", "pla", "bab"};

        List<String> list = Arrays.asList(arr);
        System.out.println(groupAnagrams(list));
    }

    public List<String> groupAnagrams(List<String> stringList){

        Map<String, List<String>> map = new HashMap<>();

        for( String s: stringList ){
            String freqArr = getFreqArr(s);

            if( !map.containsKey(freqArr) ) map.put(freqArr, new LinkedList<>());
            map.get(freqArr).add(s);
        }

        List<String> groupedAnagrams = new ArrayList<>();

        for( String key: map.keySet() ){
            groupedAnagrams.addAll(map.get(key));
        }

        return groupedAnagrams;
    }

    public String getFreqArr(String s){
        int[] freqArr = new int[26];

        for(char c: s.toCharArray()){
            freqArr[c-'a']++;
        }

        return Arrays.toString(freqArr);
    }

}
