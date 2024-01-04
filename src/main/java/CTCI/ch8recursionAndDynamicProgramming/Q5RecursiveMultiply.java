package CTCI.ch8recursionAndDynamicProgramming;

public class Q5RecursiveMultiply {

    public static void main(String[] args) {
        new Q5RecursiveMultiply().run();
    }

    public void run(){
        System.out.println(minProduct(4,5) + " " + minProductMem(4,5));
        System.out.println(minProduct(5, 3) + " " + minProductMem(7,5));
        System.out.println(minProduct(5, 4));
        System.out.println(minProductLgn(5, 5));
        System.out.println(minProductLgn(5, 7));
        System.out.println(minProductLgn(4, 4));
    }

    int minProduct(int a, int b){
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        return minProductHelper(smaller, bigger);
    }

    private int minProductHelper(int smaller, int bigger) {
        if( smaller == 0 ) return 0;
        else if( smaller == 1 ) return bigger;

        int s = smaller >> 1;
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if( smaller % 2 == 1 ){
            side2 = minProductHelper(smaller-s, bigger);
        }

        return side1+side2;
    }

    int[] dp;

    int minProductMem(int a, int b){
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        dp = new int[smaller+1];

        return minProductHelperMem(smaller, bigger);
    }

    private int minProductHelperMem(int smaller, int bigger) {
        if( dp[smaller] > 0 ) return dp[smaller];
        if( smaller == 0 ) return 0;
        else if( smaller == 1 ) return bigger;

        int s = smaller >> 1;
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if( smaller % 2 == 1 ){
            side2 = minProductHelper(smaller-s, bigger);
        }

        return dp[smaller] = side1+side2;
    }

    int minProductLgn(int a, int b){
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        dp = new int[smaller+1];

        return minProductHelperLgn(smaller, bigger);
    }

    private int minProductHelperLgn(int smaller, int bigger) {
        if( smaller == 0 ) return 0;
        else if( smaller == 1 ) return bigger;

        int s = smaller >> 1;
        int halfProd = minProductHelperLgn(s, bigger);

        if( smaller % 2 == 0 ) return halfProd+halfProd;
        else return halfProd + halfProd + bigger;
    }


}
