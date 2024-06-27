package leetcode.hard;

import java.util.*;

//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[],[90],[]]
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[],[2],[],[3],[]]
//["MedianFinder","addNum","addNum","findMedian"]
//[[],[1],[2],[]]
//["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
public class L295FindMedianFromDataStream {
    List<Integer> lst = new ArrayList<>();

    public L295FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        lst.add(num);
    }

    public double findMedian() {
        Collections.sort(lst);
        int len = lst.size();
        int mid = len/2;
        if( len % 2 != 0 ) return lst.get(mid);

        return (lst.get(mid) + lst.get(mid - 1)) / 2.0;
    }


    class MedianFinder2 {

        PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> larger = new PriorityQueue<>();
        int median = Integer.MIN_VALUE;

        public MedianFinder2() {

        }

        //2,3,6
        //5,6,7

        public void addNum(int num) {
            smaller.add(num);

            if( !larger.isEmpty() && (smaller.peek() > larger.peek()) )
                larger.add(smaller.poll());

            if( smaller.size() < larger.size()-1 )
                smaller.add(larger.poll());

            if( larger.size() < smaller.size()-1 )
                larger.add(smaller.poll());
        }

        public double findMedian() {
            if( smaller.size() > larger.size() ) return smaller.peek();
            if( larger.size() > smaller.size() ) return larger.peek();

            return (smaller.peek()+larger.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
