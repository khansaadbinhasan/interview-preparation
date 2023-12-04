package leetcode.medium;

//5
//2
//6
//5
//1
//1
//10
//1
//100
//10
//500
//7
public class L1823FindWinnerInCircularGame {

    public static void main(String[] args) {
        new L1823FindWinnerInCircularGame().run();
    }

    public void run(){
        System.out.println(findTheWinner(5,2));
        System.out.println(findTheWinner(6,5));
    }

    public int findTheWinner(int n, int k) {
        int size = n;
        int last = -1;
        int[] arr = new int[n];

        for( int i = 1; i <= n; i++ ){
            arr[i-1] = i;
        }

        int i = 0;

        while( size > 1 ){
            int j = 1;
            while( j < k ){
                while( arr[i] == -1 ){
                    i = (i+1) % n;
                }

                j++;
                i = (i+1) % n;
            }

            while( arr[i] == -1 ){
                i = (i+1) % n;
            }

            arr[i] = -1;
            size--;
        }

        for( i = 0; i < n; i++ ){
            if( arr[i] != -1 ) return arr[i];
        }

        return last;
    }
}
