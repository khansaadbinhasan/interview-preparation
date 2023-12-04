package leetcode.medium;

import java.util.*;

//[[1],[2],[3],[]]
//[[1,3],[3,0,1],[2],[0]]
//[[1,3],[3,1],[2,3],[0,4],[1,2]]
//[[1,3],[3,1],[2,3],[1,2]]
//[[], [1]]
//[[1],[1]]
public class L841KeysAndRooms {

    public static void main(String[] args) {
        new L841KeysAndRooms().run();
    }

    public void run(){
        LinkedList<List<Integer>> rooms = new LinkedList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new LinkedList<>());

        System.out.println(canVisitAllRooms(rooms));

        rooms.clear();
        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> roomsToBeOpened =  new HashSet<>();

        for( int i = 0; i < rooms.size(); i++ ){
            roomsToBeOpened.add(i);
        }

        Set<Integer> keys =  new HashSet<>();
        Set<Integer> roomsOpened =  new HashSet<>();

        keys.add(0);

        Iterator<Integer> iterator = keys.iterator();
        Queue<Integer> keyList = new LinkedList<>();
        keyList.add(0);


        while( !keyList.isEmpty() ){
            int key = keyList.poll();

            List<Integer> room = rooms.get(key);

            for (int i = 0; i < room.size(); i++) {
                if( !keys.contains(room.get(i)) ) keyList.add(room.get(i));
            }

            keys.addAll(room);
            roomsOpened.add(key);
            rooms.set(key, new LinkedList<>());
        }

        return roomsToBeOpened.equals(keys);
    }


}
