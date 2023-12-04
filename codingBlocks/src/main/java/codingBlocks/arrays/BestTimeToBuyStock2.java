package codingBlocks.arrays;

//9
//7 1 5 4 3 4 5 6 2
//6
//7 1 5 3 6 4
//5
//1 2 3 4 5
//5
//7 6 4 3 1
//8
//9 19 8 3 19 26 10 19
//5
//7 1 7 1 7
//1
//1
//2
//1 50
//3
//5 5 5
//8
//100 100 100 89 90 90 10 100
//9
//8 7 62 24 23 43 32 43 89
//6
//10 10 6 10 10 20
//9
//7 18 9 19 10 11 18 17 30
//3
//1 3 2
//4
//3 3 3 1
//4
//3 3 3 5
//4
//10 3 3 3
//5
//10 3 3 3 10
//8
//3 3 5 0 0 3 1 4

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BestTimeToBuyStock2 {

    public static void main(String[] args) {
        new BestTimeToBuyStock2().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] stocks = new int[N];

        for(int i = 0; i < N; i++) {
            stocks[i] = sc.nextInt();
        }

//        System.out.println(getMaxProfitFromStocks(stocks));
        System.out.println(maxProfit(stocks));
    }

    public int maxProfit(int[] prices){

        if( prices.length == 0 ) return 0;

        int i = 0;
        int ans = 0;
        int valley = prices[0];
        int peak = prices[0];

        while( i < prices.length ){

            while( i < prices.length && prices[i] > prices[i+1] ) i++;
            valley = prices[i];

            while( i < prices.length && prices[i] < prices[i+1] ) i++;
            peak = prices[i];

            ans += (peak - valley);
        }

        return ans;
    }

    public int getMaxProfitFromStocks(int[] stocks){

        if( stocks.length == 1 ) return 0;

        int vind = 0;
        int profitSum = 0;

        Integer[] peaks = getPeaks(stocks);
        Integer[] valleys = getValleys(stocks);

//        for( int peak: peaks ) System.out.print(stocks[peak] + " ");
//        System.out.println();
//
//        for( int valley: valleys ) System.out.print(stocks[valley] + " ");
//        System.out.println();

        for( int peak: peaks ){

            if( valleys.length == vind ) break;

            if( peak > valleys[vind] ){
                profitSum += (stocks[peak] - stocks[valleys[vind]]);
                vind++;
            }
        }

        return profitSum;
    }

    public Integer[] getPeaks(int[] stocks){
        List<Integer> peaks = new ArrayList<>();

        if( stocks[0] > stocks[1] ) peaks.add(0);


        for (int i = 1; i < stocks.length-1; i++){
            if( stocks[i] > stocks[i-1] && stocks[i] > stocks[i+1] ) peaks.add(i);

            if( stocks[i] == stocks[i-1] && stocks[i] > stocks[i+1] ) peaks.add(i);

            if( stocks[i] > stocks[i-1] && stocks[i] == stocks[i+1] ) peaks.add(i);
        }


        if( stocks[stocks.length-1] > stocks[stocks.length-2] ) peaks.add(stocks.length-1);

        return peaks.toArray(new Integer[peaks.size()]);
    }

    public Integer[] getValleys(int[] stocks){
        List<Integer> valleys = new ArrayList<>();

        if( stocks[0] < stocks[1] ) valleys.add(0);

        for (int i = 1; i < stocks.length-1; i++){
            if( stocks[i] < stocks[i-1] && stocks[i] < stocks[i+1] ) valleys.add(i);

            if( stocks[i] == stocks[i-1] && stocks[i] < stocks[i+1] ) valleys.add(i);

            if( stocks[i] < stocks[i-1] && stocks[i] == stocks[i+1] ) valleys.add(i);
        }


        if( stocks[stocks.length-1] < stocks[stocks.length-2] ) valleys.add(stocks.length-1);

        return valleys.toArray(new Integer[valleys.size()]);
    }

}
