package codingBlocks.stacksAndQueues;

import java.util.*;

public class ExclusiveTimesOfFunctions {

    public static void main(String[] args) {
        new ExclusiveTimesOfFunctions().run();
    }

    public void run() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int N = sc.nextInt();
        List<String> logs = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            logs.add(sc.next());
        }

        for( int time: exclusiveTime(n, logs) ){
            System.out.print(time + " ");
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {


        Stack<Integer> callStack = new Stack<>();
        int[] exclusiveTimes = new int[n];
        int[] timestampArr = new int[n];

        Arrays.fill(exclusiveTimes, 0);

        for( String log: logs ){

            String[] functionInfo = log.split(":");

            int funcId = Integer.parseInt(functionInfo[0]);
            String startEnd = functionInfo[1];
            int timestamp = Integer.parseInt(functionInfo[2]);

            if( startEnd.equals("start") ){
                if( !callStack.isEmpty() ) {
                    int peekId = callStack.peek();
                    exclusiveTimes[peekId] += timestamp - timestampArr[peekId];
                }

                callStack.push(funcId);
                timestampArr[funcId] = timestamp;
            }

            else if( startEnd.equals("end") ){
                exclusiveTimes[funcId] += timestamp - timestampArr[funcId] + 1;
                callStack.pop();

                if( !callStack.isEmpty() ) timestampArr[callStack.peek()] = timestamp + 1;
            }

        }

        return exclusiveTimes;
    }

}
