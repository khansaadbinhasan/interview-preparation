package CTCI.ch17hard;

public class Q10MajorityElement {

    public static void main(String[] args) {
        new Q10MajorityElement().run();
    }

    public void run(){
        System.out.println(findMajorityElement(new int[]{1,2,3,5,5,5,5,5,6}));
        System.out.println(findMajorityElement(new int[]{5,5,3,3,3,3,5,5,5}));
    }

    public int findMajorityElement(int[] array){
        int candidate = getCandidate(array);
        return validate(array, candidate) ? candidate: -1;
    }

    public int getCandidate(int[] array){
        int majority = 0;
        int count = 0;

        for( int n: array ) {
            if( count == 0 ) majority = n;
            if( n == majority ) count++;
            else  count--;
        }

        return majority;
    }

    public boolean validate(int[] array, int majority){
        int count = 0;
        for(int n: array){
            if( n == majority ) count++;
        }

        return count > array.length/2;
    }

}
