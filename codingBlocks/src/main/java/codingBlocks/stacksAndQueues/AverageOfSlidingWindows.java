package codingBlocks.stacksAndQueues;

import java.util.*;

public class AverageOfSlidingWindows {

    public static void main(String[] args) {
        new AverageOfSlidingWindows().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        List<Integer> nums = new ArrayList<>();

        int num = sc.nextInt();

        while( num != -1 ){
            nums.add(num);
            num = sc.nextInt();
        }

        int[] a = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            a[i] = nums.get(i);
        }

//        double[] avg = windowAverage(a, k);
        double[] avg = windowAvgUsingQueue(a, k);

        for (int i = 0; i < avg.length; i++) {
            System.out.printf("%.4f ", avg[i]);
        }

    }

    private double[] windowAvgUsingQueue(int[] a, int k){

        Queue<Integer> q = new LinkedList<>();
        double[] avg = new double[a.length];
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            if( q.size() == k ) sum -= q.poll();
            q.add(a[i]);
            sum += a[i];
            avg[i] = (double) sum / q.size();
        }

        return avg;

    }

    private double[] windowAverage(int[] a, int k) {

        int i = 0;
        int sum = 0;
        int count = 0;
        int N = a.length;
        double[] avg = new double[N];

        for (int j = i; j < N; j++) {
            if( j <= (k-1) ) count++;

            if( j > (k-1) ) {
                sum -= a[i];
                i++;
            }

            sum += a[j];
            avg[j] = (double) sum / count;
//            avg[j] = (double)Math.round(avg[j] * 10000) / 10000;
        }

        return avg;
    }

}
