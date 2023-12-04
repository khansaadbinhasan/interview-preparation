package codingBlocks.hashing;

import java.util.*;

public class AnagramsTogether {

    public static void main(String[] args) {
        new AnagramsTogether().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] strs = new String[N];

        for (int i = 0; i < N; i++) {
            strs[i] = sc.next();
        }

        groupAnagrams(strs).forEach(lst -> {
            lst.forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    public List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> lstStrs = new LinkedList<>();

        Map<Map<String, Integer>, List<String>> mapList = new HashMap<>();

        for( String s: strs ){

            Map<String, Integer> map = getFrequencyMap(s);

            if( mapList.isEmpty() || !mapList.containsKey(map) )
                mapList.put(map, new LinkedList<>(Arrays.asList(s)));

            else mapList.get(map).add(s);
        }

        for( Map<String, Integer> map: mapList.keySet() ){
            lstStrs.add(mapList.get(map));
        }

        return lstStrs;
    }

    public Map<String, Integer> getFrequencyMap(String str){

        Map<String, Integer> map = new HashMap<>();

        for( String s: str.split("") ){
            if( !map.isEmpty() && map.containsKey(s) )
                map.put(s, map.get(s)+1);
            else map.put(s, 1);
        }

        return map;
    }
}
