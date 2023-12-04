package interviews.flipkartSDE1.practice.processMem.models;

import java.util.LinkedList;
import java.util.List;

public class Process {

    private static final int MIN_PID = 1000;
    private static final int MAX_PID = 9999;

    private static int currentPID = MIN_PID;
    private int pid;
    private boolean isRunning;

    private List<Process> childs;

    public Process() throws Exception {
        if (isCurrPIDValid()) this.pid = currentPID;
        else throw new Exception();

        this.isRunning = false;
        currentPID++;

        childs = new LinkedList<>();
    }

    //implement this
    public boolean isCurrPIDValid() {
        return currentPID >= MIN_PID && currentPID <= MAX_PID;
    }

    public int getPid() {
        return pid;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public List<Process> getChilds() {
        return childs;
    }

    public void addChild(Process process){
        childs.add(process);
    }

    @Override
    public String toString() {
        return "Process{" +
                "pid=" + pid +
                ", isRunning=" + isRunning +
                ", childs=" + childs +
                '}';
    }
}
