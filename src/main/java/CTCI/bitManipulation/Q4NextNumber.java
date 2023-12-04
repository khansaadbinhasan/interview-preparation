package CTCI.bitManipulation;

public class Q4NextNumber {


    public int getNext(int n){
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while( ((c&1) == 0) && (c!= 0) ){
            c0++;
            c = c >> 1;
        }

        while( (c&1) == 1 ){
            c1++;
            c = c >> 1;
        }

        if( c0 + c1 == 31 || c0 + c1 == 0 ) return -1;

        int p = c0 + c1;

        n |= (1 << p);
        n &= -(1 << p);
        n |= (1 << (c1-1)) - 1;

        return n;
    }

    int getPrev(int n){
        int temp = n;
        int c0 = 0;
        int c1 = 0;

        while( (temp & 1) == 1 ){
            c1++;
            temp = temp >> 1;
        }

        if( temp == 0 ) return -1;

        while( ((temp & 1) == 0) && (temp != 0) ){
            c0++;
            temp = temp >> 1;
        }

        int p = c0 + c1;
        n &= ((~0) << (p+1));

        int mask = (1 << (c1+1)) - 1;
        n |= mask << (c0-1);

        return n;
    }

//    public int getNextArith(int n){
////        return n + (1 << c0) + (1<< (c1-1)) -1;
//    }

}
