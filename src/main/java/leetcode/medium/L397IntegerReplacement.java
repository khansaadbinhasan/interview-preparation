package leetcode.medium;

public class L397IntegerReplacement {
    public int integerReplacement(int n) {

        int count = 0;

        if( n == Integer.MAX_VALUE ) {
            n--;
            count++;
        }

        while( n != 1 ){
            if( isEven(n) ) n = n >> 1;
            else {
                if( isAddOne(n) ) n++;
                else n--;
            }

            count++;
        }

        return count;
    }

    public boolean isAddOne(int n){

        int numSetBitPlus1 = getNumSetBits(n+1);
        int numSetBitMin1 = getNumSetBits(n-1);

        if( numSetBitPlus1 < numSetBitMin1 ) return true;
        else if( numSetBitPlus1 > numSetBitMin1 ) return false;

        int indexOfFinalSetBitMin1 = getIndexOfFinalSetBit(n-1);
        int indexOfFinalSetBitPlus1 = getIndexOfFinalSetBit(n+1);

        if( indexOfFinalSetBitPlus1 < indexOfFinalSetBitMin1  ) return true;
        else if( indexOfFinalSetBitPlus1 > indexOfFinalSetBitMin1 ) return false;

        return false;
    }

    public int getIndexOfFinalSetBit(int n){
        int count = 0;

        while( n != 0 ){
            count++;
            n = n >> 1;
        }

        return count == 0 ? 0: count-1;
    }

    public int getNumSetBits(int n){
        int count = 0;

        while( n != 0 ){
            if( (n & 1) == 1 ) count++;

            n = n >> 1;
        }

        return count;
    }

    public boolean isEven(int n){
        return n % 2 == 0;
    }

    public int integerReplacement2(int n) {
        return intRep(n);
    }

    public int intRep(int n) {
        if( n == 1 ) return 0;
        if( n % 2 == 0 ) return intRep(n/2);
        return Math.min(intRep(n-1),intRep(n+1));
    }

    public static void main(String[] args) {
        new L397IntegerReplacement().run();
    }

    public void run(){
//        System.out.println(intRep());
    }

    public int integerReplacement5(int n) {
        return intRep(n);
    }

    public int intRep(long n) {
        if( n == 1 ) return 0;
        if( n % 2 == 0 ) return 1+intRep(n/2);
        return 1+Math.min(intRep(n-1),intRep(n+1));
    }

}
