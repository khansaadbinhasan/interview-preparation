package codingBlocks.arrays;

import java.util.Scanner;

//6
//10 20 30 40 50 60
//30 40 50 40 10 20

//4
//20 40 10 10
//40 30 40 20

//4
//20 40 40 10
//40 30 20 20

//4
//20 40 40 70
//40 45 45 40

//4
//40 30 40 100
//10 70 10 40

//6
//1
//4
//2
//3
//6
//2
//2
//3
//4
//5
//6
//7

public class PetrolPump {

    public static void main(String[] args) {
        new PetrolPump().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] petrolArr = new int[N];
        int[] costArr = new int[N];

        for (int i = 0; i < N; i++) {
            petrolArr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            costArr[i] = sc.nextInt();
        }

        System.out.println(printPossiblePetrolPumps(petrolArr, costArr));
    }

    private int printPossiblePetrolPumps(int[] petrolArr, int[] costArr) {


        int net = 0;
        int curr = 0;
        int start = 0;

        for (int i = 0; i < petrolArr.length; i++) {
            net += petrolArr[i] - costArr[i];
            curr += petrolArr[i] - costArr[i];;

            if( curr < 0 ){
                curr = 0;
                start = i + 1;
            }
        }

        if( net < 0 ) return -1;

        return start;
    }

}
