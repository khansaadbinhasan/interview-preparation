package advancedRecursion;

public class CoinGameTheory {

    public static void main(String[] args) {
        new CoinGameTheory().run();
    }

    private void run() {

        int[] a = new int[]{1,5,700,2};
        System.out.println(chooseCoin(a, 0, a.length-1));

    }

    public int chooseCoin(int[] a, int l, int r){

        if( l + 1 == r ) return Math.max(a[l], a[r]);

        return Math.max(
                        a[l] + Math.min(chooseCoin(a, l+2, r),chooseCoin(a, l+1, r-1)),
                          a[r] + Math.min(chooseCoin(a, l+1, r-1), chooseCoin(a, l, r-2))
        );

    }


}
