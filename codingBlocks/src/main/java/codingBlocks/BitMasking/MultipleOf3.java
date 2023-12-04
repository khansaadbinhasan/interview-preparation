package codingBlocks.BitMasking;

import java.util.*;

//01111001101011000001011000111100011101011110100101010010001110101011101010100101000001101000010000110001110100010011101011111111110110101100101110001010101011110001010000010111110011011010111110011010011100000001110010101010011001000111001001100001011100100000100000100000110011110100111101110010000000001101010001100010110111110110110100000010100000011010001000011100100111001001011110110010000010001000000101110001001000110111110010010110001000100000111100101101110101101101111100111100110100011001

public class MultipleOf3 {

    public static void main(String[] args) {
        new MultipleOf3().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        List<Integer> ansList = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            String bin = sc.next();

            ansList.add( isMultipleOf3(bin) ? 1: 0);
        }

        ansList.forEach( ans -> System.out.println(ans));
    }

    public boolean isMultipleOf3(String bin){
        int sum = 0;

        System.out.println(bin.length());

//        for (int i = bin.length()-1; i >= 0; i--) {
//            int binAtI = bin.charAt(i) - '0';
//            sum += ((int) Math.pow(2, bin.length() - i - 1) * binAtI) % 3;
//        }
//

        for (int i = bin.length()-1; i >= 0; i--) {
            int binAtI = bin.charAt(i) - '0';

            sum += (i % 2 == 0 ? 1: 2)*binAtI;
        }


        return sum % 3 == 0;
    }

    public boolean isMultipleOf3Old(String bin){
        int[] setBitsIndices = whereSetBits(bin);

        int N = setBitsIndices.length;

        System.out.println(Arrays.toString(setBitsIndices));

        if( N < 2 ) return false;

        if( isEven(N) ){
            for (int i = 0; i < N; i+=2) {
                if( isEven(setBitsIndices[i] - setBitsIndices[i+1]) ) return false;
            }
        }

        else {
            for (int i = 0; i < N-1; i++) {
                if( !isEven(setBitsIndices[i] - setBitsIndices[i+1]) ) return false;
            }
        }

        return true;
    }

    public int[] whereSetBits(String bin){

        List<Integer> indicesList = new LinkedList<>();

        for( int i = bin.length()-1; i >= 0; i-- ){

            if( bin.charAt(i) == '1' ) indicesList.add(bin.length() - i - 1);
        }

        Collections.reverse(indicesList);

        int[] indicesArr = new int[indicesList.size()];

        for(int i = 0; i < indicesList.size(); i++){
            indicesArr[i] = indicesList.get(i);
        }

        return indicesArr;
    }

    public boolean isEven(int num){
        return num % 2 == 0;
    }
}
