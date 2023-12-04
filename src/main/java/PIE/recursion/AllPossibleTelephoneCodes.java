package PIE.recursion;

import java.util.*;

public class AllPossibleTelephoneCodes {

    public static void main(String[] args) {
        new AllPossibleTelephoneCodes().run();
    }

    public void run(){

        int[] phoneNumber = new int[]{9,8};

        List<String> numbersTillNow = getTelephoneHashmap().get(phoneNumber[0]);

        System.out.println(telephoneAlphaPrint(numbersTillNow, phoneNumber, 1));
    }

    public List<String> telephoneAlphaPrint(List<String> numbersTillNow, int[] phoneNumber, int i){

        if( i == phoneNumber.length ) return numbersTillNow;

        List<String> nextNum = getTelephoneHashmap().get(phoneNumber[i]);

        List<String> newNumbersTillNow = new ArrayList<>();

        for (int j = 0; j < numbersTillNow.size(); j++) {
            for (int k = 0; k < nextNum.size(); k++) {
                newNumbersTillNow.add(numbersTillNow.get(j)+nextNum.get(k));
            }
        }

        return telephoneAlphaPrint(newNumbersTillNow, phoneNumber, i+1);
    }

    public Map<Integer, List<String>> getTelephoneHashmap(){

        Map<Integer, List<String>> m = new HashMap<>();

        m.put(0, Arrays.asList(""));
        m.put(1, Arrays.asList(""));
        m.put(2, Arrays.asList("A", "B", "C"));
        m.put(3, Arrays.asList("D", "E", "F"));
        m.put(4, Arrays.asList("G", "H", "I"));
        m.put(5, Arrays.asList("J", "K", "L"));
        m.put(6, Arrays.asList("M", "N", "O"));
        m.put(7, Arrays.asList("P", "R", "S"));
        m.put(8, Arrays.asList("T", "U", "V"));
        m.put(9, Arrays.asList("W", "X", "Y"));

        return m;
    }

}
