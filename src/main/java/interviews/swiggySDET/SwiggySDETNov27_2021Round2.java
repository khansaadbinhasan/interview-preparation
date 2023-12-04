package interviews.swiggySDET;

import java.util.*;

public class SwiggySDETNov27_2021Round2 {

    //    [4,5,2,7,6,1,3,9,11,13]
//    {4,5,2,7,6,1,3,9,11,13}
//    sum =9
//    sum =9
//    {4,5},{2,7},{6,3}
    public Set<String> getPairs(int[] arr, int sum){

        Set<Integer> set = new HashSet<>();

        //add to set
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Set<String> pairSet = new HashSet<>();

        //{4,5}
        //{5,4}
        for (int i = 0; i < arr.length; i++) {
            int second = sum-arr[i];

            if( set.contains(second) ){
                if( !pairSet.contains(Arrays.toString(new int[]{arr[i], second})) &&
                        !pairSet.contains(Arrays.toString(new int[]{second, arr[i]}))
                ){
                    pairSet.add(Arrays.toString(new int[]{arr[i], second}));
                }

            }
        }

        return pairSet;
    }


    //<a>
    //  <b>
    //
    //  </b>
    //</a>

    //2xx
    //4xx
    //5xx

    //dto
    //json
    //pojo


    //    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<HashSet<String>> getPairOfAnagrams(String[] strs){

        Map<String, HashSet<String>> map = new HashMap<>();

        //{freqArr: HashSet<>(){tea, ate, eat}
        // }
        //
        for (int i = 0; i < strs.length; i++) {
            String key = freqArr(strs[i]);

            if( !map.containsKey(key) ){
                map.put(key, new HashSet<>());
            }

            HashSet<String> set = map.get(key);

            set.add(strs[i]);

            map.put(key, set);
        }

        List<HashSet<String>> lst = new LinkedList<>();

        for(String key: map.keySet()){
            lst.add(map.get(key));
        }

        return lst;

    }

    public String freqArr(String s){
        int[] freqArr = new int[26];

        Arrays.fill(freqArr, 0);

        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i)-'a']++;
        }

        return Arrays.toString(freqArr);
    }

    //book an uber cab

    //booking cab
    //finding driver partner

    //app doesnt' crash
    //it should ask for location permission(if it doesn't have)
    //if not logged in ask to login
    //that the location shown is correct(error maring)
    //fares that it shows are for that city
    //currency (rupee, dollar)
    //if many people are using it should not crash
    //it should not ask to login if already logged in
    //the payment gateway, whehter provides all the things like UPI, Baking etc.
    //payment is going to correct account


    //Request
    //


        public void hitAPITEST(){

    //    HttpRequest httpRequest = new HttpRequest();
    //
    //
    //
    //    httpRequest.get("/api/users")

        }


}
