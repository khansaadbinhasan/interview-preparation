package leetcode.easy;

//00000010100101000001111010011100
//11111111111111111111111111111101
//10000000000000000000000000000000
//00000000000000000000000000000000
//11111111111111111111111111111111
//00000000000000111111111110000000
//10000000110101001000000111111001
//00000010100101000001111010011100
//11111111111111111111111111111101
import java.util.LinkedList;
import java.util.Queue;

public class L190ReverseBits {

    public static void main(String[] args){
        int i = new L190ReverseBits().reverseBits(964176192);

        System.out.println(i);
    }


    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        Queue<Integer> queue = new LinkedList<>();

        int bits32 = 32;

        while( bits32-- > 0 ){
            queue.add(n & 1);
            n = n >>> 1;
        }

        int num = 0;

        while(!queue.isEmpty()){
            int bin = queue.remove();

            num = num << 1;

            if( bin == 1) num = num + 1;
        }

        return num;
    }

}
