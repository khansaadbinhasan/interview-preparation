package leetcode.hard;

import java.util.*;

public class L857MinCostToHireKWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        double minCost = Double.MAX_VALUE;

        for( int j = 0; j < quality.length; j++ ){

            PriorityQueue<Double> minHeap = new PriorityQueue<>();
            double frac = 1.0*quality[j]/wage[j];

            for( int i = 0; i < quality.length; i++ ){
                if( 1.0*quality[i]/wage[i] >= frac )
                    minHeap.add(quality[i]*1.0/frac);//wage needs to be updated as per fraction
            }

            if(minHeap.size() < k) continue;

            double cost = 0;
            for( int i = 0; i < k; i++ ){
                cost += minHeap.poll();
            }

            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public double mincostToHireWorkers2(int[] quality, int[] wage, int k) {

        double minCost = Double.MAX_VALUE;

        for( int j = 0; j < quality.length; j++ ){

            PriorityQueue<double[]> minHeap = getMinHeap();
            double frac = 1.0*quality[j]/wage[j];

            for( int i = 0; i < quality.length; i++ ){
                if( 1.0*quality[i]/wage[i] >= frac )
                    minHeap.add(new double[]{quality[i], quality[i]*1.0/frac});//wage needs to be updated as per fraction
            }

            if(minHeap.size() < k) continue;

            double cost = 0;
            for( int i = 0; i < k; i++ ){
                cost += minHeap.poll()[1];
            }

            System.out.println(cost);

            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public PriorityQueue<double[]> getMinHeap(){
        return new PriorityQueue<>(
                new Comparator<double[]>(){
                    @Override
                    public int compare(double[] a, double[] b){
                        return Double.compare(a[1]*b[0],a[0]*b[1]);//[[0,1]] 0 -> quality, 1 -> wage
                    }
                }
        );
    }

    public static void main(String[] args) {
        new L857MinCostToHireKWorkers().run();
    }

    public void run(){
//        System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
        System.out.println(mincostToHireWorkers(new int[]{1,2,3,4,5,6,7,8,10000}, new int[]{10000,8,7,6,5,4,3,2,1}, 3));
    }

}
