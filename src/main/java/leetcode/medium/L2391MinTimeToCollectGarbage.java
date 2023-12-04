package leetcode.medium;

//["G","P","GP","GG"]
//[2,4,3]
//["MMM","PGM","GP"]
//[3,10]
//["M","M"]
//[1]
//["MGP","GMP"]
//[3]
//["MMMMM","GGGGG"]
//[2]
public class L2391MinTimeToCollectGarbage {

    public static void main(String[] args) {
        new L2391MinTimeToCollectGarbage().run();
    }

    public void run(){
        System.out.println(garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2,4,3}));
    }

    public int garbageCollection(String[] garbage, int[] travel) {

        int collectM = collectGarbage(garbage, travel, 'M');
        int collectP = collectGarbage(garbage, travel, 'P');
        int collectG = collectGarbage(garbage, travel, 'G');

        return collectM + collectP + collectG;

    }

    public int collectGarbage(String[] garbage, int[] travel, char garbageType){

        int garbageCount = 0;

        while( containsChar(garbage[0], garbageType) ){
            garbageCount++;
            garbage[0] = garbage[0].replaceFirst(String.valueOf(garbageType), "");
        }

        int lastInd = 0;
        for( int i = garbage.length-1; i >= 0; i-- ){
            if( containsChar(garbage[i], garbageType) ){
                lastInd = i;
                break;
            }
        }

        for( int i = 1; i <= lastInd; i++ ){
            garbageCount += travel[i-1];
            while( containsChar(garbage[i], garbageType) ){
                garbageCount++;
                garbage[i] = garbage[i].replaceFirst(String.valueOf(garbageType), "");
            }
        }

        return garbageCount;
    }

    public boolean containsChar(String s, char c){
        return s.contains(String.valueOf(c));
    }
}
