package codingBlocks.arrays;

import java.util.*;

public class PartyHall {
    public static void main (String[] args)
    {
        new PartyHall().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        StartEnd[] startEnds = new StartEnd[N];

        for (int i = 0; i < N; i++) {
            startEnds[i] = new StartEnd(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(startEnds, new SortByStartEnd());
        System.out.println(getMinRoomsForParty(Arrays.asList(startEnds)));
    }

    public int getMinRoomsForParty(List<StartEnd> startEnds){

        if( startEnds.isEmpty() ) return 0;

        List<StartEnd> partyHallsList = new ArrayList<>();

        for( StartEnd startEnd: startEnds ){
            boolean isPossibleToAdd = false;
            for( int i = 0; i < partyHallsList.size(); i++ ){
                if( isPossibleToPutOnHall(partyHallsList.get(i), startEnd) ){
                    isPossibleToAdd = true;
                    partyHallsList.set(i, startEnd);
                    break;
                }
            }

            if( !isPossibleToAdd ){
                partyHallsList.add(startEnd);
            }
        }

        return partyHallsList.size();
    }

    public boolean isPossibleToPutOnHall(StartEnd partyHall, StartEnd startEnd){
        return startEnd.start >= partyHall.end;
    }

}

class StartEnd
{
    int start;
    int end;

    public StartEnd(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}

class SortByStartEnd implements Comparator<StartEnd>
{
    public int compare(StartEnd a, StartEnd b)
    {
        return a.start - b.start;
    }
}