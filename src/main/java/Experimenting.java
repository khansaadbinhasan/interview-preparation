import java.util.*;


public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run() {
        int[][] a = new int[][]{{5,6},{1,2},{3,4}};

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        // Custom comparison logic
                        return a[0]-b[0]; // Reverse order (descending)
                    }
                }
        );

        priorityQueue.addAll(Arrays.asList(a));

        while( !priorityQueue.isEmpty() ){
            System.out.println(Arrays.toString(priorityQueue.poll()));
        }
    }
}



