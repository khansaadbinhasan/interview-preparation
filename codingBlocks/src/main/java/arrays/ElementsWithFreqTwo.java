package arrays;

import java.util.*;

//8
//4 3 2 7 8 2 3 1
//6
//4 4 4 2 2 3
//9
//4 3 2 4 2 0 0 3 1

public class ElementsWithFreqTwo {
    public static void main(String[] args) {
        new ElementsWithFreqTwo().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

//        System.out.println(getElemsWithFreqTwo(arr));
        System.out.println(getElemsWithFreqTwoUsingArr(arr));
    }

    public List getElemsWithFreqTwo(int[] arr){

        SortedMap<Integer, Integer> freqMap = new TreeMap<>();

        for( int elem: arr ){
            if( freqMap.get(elem) == null ) {
                freqMap.put(elem, 1);
                continue;
            }

            freqMap.put(elem, freqMap.get(elem) + 1);
        }

        List<Integer> freq2Lst = new ArrayList<>();

        for( Integer key: freqMap.keySet() ){
            if( freqMap.get(key) == 2 ) freq2Lst.add(key);
        }

        return freq2Lst;
    }

    public List getElemsWithFreqTwoUsingArr(int[] arr){

        int[] freqArr = new int[arr.length+1];

        for( int elem: arr ){
            freqArr[elem] += 1;
        }

        List<Integer> freqLst = new ArrayList<>();

        for(int i = 0; i < freqArr.length; i++){
            if(freqArr[i] == 2) freqLst.add(i);
        }

        return freqLst;
    }
}
