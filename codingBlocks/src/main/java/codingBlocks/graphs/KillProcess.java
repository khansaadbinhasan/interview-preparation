package codingBlocks.graphs;

import java.util.*;

public class KillProcess {

    public static void main(String[] args) {
        new KillProcess().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int kill = sc.nextInt();

        List<Integer> pid = new LinkedList<>();
        List<Integer> ppid = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            pid.add(sc.nextInt());
        }

        for (int i = 0; i < N; i++) {
            ppid.add(sc.nextInt());
        }

        killProcess(pid, ppid, kill).forEach(p -> System.out.print(p + " "));
    }

    List<Integer> killedProcesses = new LinkedList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill){

        killedProcesses.add(kill);

        if( !ppid.contains(kill) && !pid.contains(kill) ) return killedProcesses;

        for( int i = 0; i < ppid.size(); i++ ){
            if( ppid.get(i) == kill ){
                ppid.set(i, -1);
                killProcess(pid, ppid, pid.get(i));
                pid.set(i, -1);
            }
        }

        return killedProcesses;
    }

    public List<Integer> killProcess2(List<Integer> pid, List<Integer> ppid, int kill){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> list = map.getOrDefault(ppid.get(i), new LinkedList<>());

            list.add(pid.get(i));
            map.put(ppid.get(i), list);
        }

        Queue<Integer> bfs = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        bfs.add(kill);

        while( !bfs.isEmpty() ){
            int curr = bfs.poll();
            list.add(curr);

            if( map.get(curr) != null ) bfs.addAll(map.get(curr));
        }

        return list;
    }

}
