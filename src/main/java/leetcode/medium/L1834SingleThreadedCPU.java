package leetcode.medium;

import misc.WriteFile;

import java.util.*;

//[[1,2],[2,4],[3,2],[4,1]]
//[[7,10],[7,12],[7,5],[7,4],[7,2]]
//[[1,1]]
//[[1,1],[2,2]]
//[[3,3],[3,2]]
//[[2,4],[3,2],[4,1],[1,2]]
//[[3,2],[4,3],[3,3],[1,1],[4,1]]
//[[1,2],[10,4],[14,2],[14,1]]
//[[100,100],[1000000000,1000000000]]
//[[35,36],[11,7],[15,47],[34,2],[47,19],[16,14],[19,8],[7,34],[38,15],[16,18],[27,22],[7,15],[43,2],[10,5],[5,4],[3,11]]
public class L1834SingleThreadedCPU {

    public static void main(String[] args) {
        new L1834SingleThreadedCPU().run();
    }

    public void run(){
//        System.out.println(Arrays.toString(getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
//        System.out.println(Arrays.toString(getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));
//        System.out.println(Arrays.toString(getOrder(new int[][]{{2, 4}, {3, 2}, {4, 1},{1, 2}})));
//        System.out.println(Arrays.toString(getOrder(new int[][]{{2, 4}, {3, 2}, {4, 1},{1, 2}})));
//        System.out.println(Arrays.toString(getOrder(new int[][]{{1, 2}, {10, 4}, {14, 2},{14, 1}})));
        new WriteFile().writeFile(genRandom2dArray(), "test.txt");
    }

    public String genRandom2dArray(){
        Random random = new Random();
        int[][] randArr = new int[random.nextInt(100_000)][2];
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < randArr.length-1; i++) {
            sb.append("[")
                    .append(random.nextInt(1000_000_000))
                    .append(",")
                    .append(random.nextInt(1000_000_000))
                    .append("]")
                    .append(",");
        }

        sb.append("[")
                .append(random.nextInt(1000_000_000))
                .append(",")
                .append(random.nextInt(1000_000_000))
                .append("]")
                .append("]");

        return sb.toString();
    }

    //Simple approach - Maintain a PQ with the logic mentioned in question
    //Sorting is needed to pick the first operation first
    public int[] getOrder(int[][] tasks) {

        int[][] tasksClone = tasks.clone();

        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};//Index is also stored since it would be messed up during sorting and index is needed later
        }

        //Sort the array so that the first task is the one we need to pick first and so on
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        //Priority queue logic mentioned in question - compare the times and then the indices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                new Comparator<>(){
                    @Override
                    public int compare(int[] a, int[] b){
                        if( a[1] == b[1] ) return Integer.compare(a[2], b[2]);
                        return Integer.compare(a[1], b[1]);
                    }
                }
        );

        int[] order = new int[tasks.length];
        long t = tasks[0][0];
        int orderI = 0;
        int i = 0;


        while( orderI < order.length){//Do while order array is not fully filled
            while( i < tasks.length && tasks[i][0] <= t ){//While any task has come before this time, add it to minheap
                minHeap.add(tasks[i]);
                i++;
            }
            if( !minHeap.isEmpty() ) {//Fill up the order array with the correct indices
                int index = minHeap.poll()[2];
                order[orderI++] = index;
                t += tasksClone[index][1]-1;//-1 since we are doing t++, can be avoided if you continue instead
            }
            else if( i < tasks.length ){//This is not needed except that TLE would be thrown otherwise
                t = tasks[i][0];
                continue;
            }
            t++;
        }

        return order;
    }
}
