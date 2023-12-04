package leetcode.medium;

//["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
//[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
//["CustomStack","pop","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
//[[3],[],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
public class L1381DesignStackWithIncrement {
    class CustomStack {

        int[] stack;
        int pointer = 0;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
        }

        public void push(int x) {
            if( pointer >= stack.length ) return;
            if( pointer < 0 ) pointer = 0;
            stack[pointer++] = x;
        }

        public int pop() {
            if( pointer <= 0 ) return -1;
            return stack[--pointer];
        }

        public void increment(int k, int val) {
            CustomStack stack2 = new CustomStack(stack.length);

            int elem = this.pop();

            while( elem >= 0 ){
                stack2.push(elem);
                elem = this.pop();
            }

            elem = stack2.pop();

            while( elem >= 0 && k > 0 ){
                elem += val;
                this.push(elem);
                elem = stack2.pop();
                k--;
            }

            while( elem >= 0 ){
                this.push(elem);
                elem = stack2.pop();
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

}
