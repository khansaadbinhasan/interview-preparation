package leetcode.medium;

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
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
