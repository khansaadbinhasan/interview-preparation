package CTCI.ch1arraysAndStrings;

public class IX_1_1_UniqueInString {


    public static void main(String[] args) {
        new IX_1_1_UniqueInString().run();
    }

    public void run(){
        String s = "some HSK";

        System.out.println("String: \"" + s + "\"" + (allUnique(s) ?  " is unique.": " is not unique."));
    }
    
    public boolean allUnique(String s){

        int[] freqArr = new int[200];

        for (int i = 0; i < s.length(); i++) {
            if( freqArr[s.charAt(i)] > 0 ) return false;

            freqArr[s.charAt(i)]++;
        }

        return true;
    }

}
