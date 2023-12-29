package leetcode.medium;

//["Solution","pickIndex"]
//[[[1]],[]]
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,5,7,5,3]],[],[],[],[],[]]
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3,4,2,10]],[],[],[],[],[]]
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex", "pickIndex","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
public class L528RandomPickWithWeight {

    int sum = 0;//4
    int pointer = 0;//3
    int ind = 0;//2
    int[] w;//1,0,3
    int[] sumArr;//1,1,4

    //1,0,3
    public L528RandomPickWithWeight(int[] weights) {
        this.w = weights;
        this.sumArr = new int[w.length];
        sumArr[0] = w[0];
        for( int i = 1; i < w.length; i++ ){
            sumArr[i] = sumArr[i-1] + w[i];
        }

        resetPointer();
        sum = sumArr[w.length-1];
    }

    //0,
    public int pickIndex() {
        if( pointer == sumArr[ind] ) ind++;
        if( pointer == sum ) resetPointer();

        pointer++;
        return ind;
    }

    public void resetPointer(){
        pointer = 0;
        ind = 0;
    }

    public static void main(String[] args) {
        L528RandomPickWithWeight obj = new L528RandomPickWithWeight(new int[]{188,927,949,95,151,659,405,906,481,363,728,839});

        for (int i = 0; i < 2000; i++) {
            System.out.printf(obj.pickIndex() + " ");
            if( i % 50 == 0 ) System.out.println();
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */