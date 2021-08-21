package heap;

import java.util.*;

public class FindKthLargestElement {

    public static void main(String[] args) {
        new FindKthLargestElement().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if ( !pq.isEmpty() && pq.size() >= k ){
                if( num > pq.peek() ) pq.poll();
                else continue;
            }

            pq.offer(num);
        }

        if( !pq.isEmpty() ) return pq.peek();
        else return Integer.MIN_VALUE;
    }

    public int findKthLargestONlgN(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }

        return pq.peek();
    }


}
