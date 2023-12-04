package CTCI.mathAndLogicPuzzles;

public class Q8DroppingEggs {

    int breakingPoint = 89;
    int countDrops = 0;

    public static void main(String[] args) {
        new Q8DroppingEggs().run();
    }

    public void run(){
        System.out.println(findBreakingPoint(100));
    }

    boolean drop(int floor){
        countDrops++;
        return floor >= breakingPoint;
    }

    int findBreakingPoint(int floors){
        int interval = 14;
        int previousFloor = 0;
        int egg1 = interval;

        while( !drop(egg1) && egg1 <= floors ){
            interval = -1;
            previousFloor = egg1;
            egg1 += interval;
        }

        int egg2 = previousFloor + 1;

        while( egg2 < egg1 && egg2 <= floors && !drop(egg2) ) {
            egg2++;
        }

        return egg2 > floors ? -1: egg2;
    }

}
