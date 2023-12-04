package codingBlocks.graphs;

import java.util.*;


//7 5
//4 2 3 0 3 1 2

//[4,2,3,0,3,1,2]
//5
//[4,2,3,0,3,1,2]
//0
//[3,0,2,1,2]
//2
//[1,2,1,1,0,1]
//3
//[1,2,3,4,5,2]
//2

public class JumpGameIII {

    public static void main(String[] args) {
        new JumpGameIII().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int start = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(canReach(arr, start)? "YES": "NO");
    }

    public boolean canReachDFS(int[] arr, int start) {

        if( arr[start] == 0 ) return true;

        Map<Integer, List<Integer>> indicesMap = new HashMap<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            List<Integer> indicesList = new LinkedList<>();

            indicesMap.put(i, indicesList);

            if( i + arr[i] < n )
            {
                indicesList = indicesMap.get(i);
                indicesList.add(i + arr[i]);
            }

            if( i - arr[i] >= 0 )
            {
                indicesList = indicesMap.get(i);
                indicesList.add(i - arr[i]);
            }
        }

//        System.out.println(indicesMap);

        Stack<Integer> st = new Stack<>();

        st.add(start);

        while( !st.isEmpty() ){
            int top = st.pop();

            List<Integer> lst = indicesMap.get(top);

            indicesMap.remove(top);

            if( lst == null ) continue;

            for( int index: lst ){
//                System.out.println(arr[index]);

                if( arr[index] == 0 ) return true;

                st.push(index);
            }

        }

        return false;
    }

    public boolean canReach(int[] arr, int start) {

        int n = arr.length;

        Queue<Integer> bfs = new LinkedList<>();

        bfs.offer(start);
        boolean[] visited = new boolean[arr.length];

        while(!bfs.isEmpty()){
            int index = bfs.poll();

            int right = index + arr[index];
            int left = index - arr[index];

            if( arr[index] == 0 ) return true;

            if( right < n && !visited[right] )
            {
                bfs.offer(right);
                visited[right] = true;
            }

            if( left >= 0 && !visited[left])
            {
                bfs.offer(left);
                visited[left] = true;
            }
        }

        return false;
    }


}
