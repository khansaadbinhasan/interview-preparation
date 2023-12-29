package coursera.algoII;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KeyIndexedCounting {

    int[] a;
    int N;
    int[] count;
    int[] aux;
    int R = 5;

    public static void main(String[] args) {
        new KeyIndexedCounting().run();
    }

    public void run(){
        a = new int[]{0,0,1,1,2,2,3,3,4,4,4,4,1,1,1,1,2,2,2,0,1,1,2,2,2,2,2,2,4,2,2,2,2,2,4,4,2,2,2,2};
        N = a.length;
        count = new int[R+1];
        aux = new int[N];
        System.out.println(Arrays.toString(keyIndexedSorting()));
    }

    public int[] keyIndexedSorting(){
        for (int i = 0; i < N; i++) {
            count[a[i]+1]++;
        }

        for (int r = 0; r < R; r++) {
            count[r+1] += count[r];
        }

        for (int i = 0; i < N; i++) {
            aux[count[a[i]]++] = a[i];
        }

        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }

        return a;
    }

}
