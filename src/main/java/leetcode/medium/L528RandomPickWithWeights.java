package leetcode.medium;

public class L528RandomPickWithWeights {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    int sum = 0;//4
    int pointer = 0;//3
    int ind = 0;//2
    int[] w;//1,0,3
    int[] sumArr;//1,1,4

    //1,0,3
    public L528RandomPickWithWeights(int[] weights) {
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

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */