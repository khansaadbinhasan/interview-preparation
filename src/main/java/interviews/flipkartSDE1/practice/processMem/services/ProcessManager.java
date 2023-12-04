package interviews.flipkartSDE1.practice.processMem.services;


import interviews.flipkartSDE1.practice.processMem.models.Process;

import java.util.HashMap;
import java.util.Map;

public class ProcessManager {

    private Map<Integer, Process> processMap = new HashMap<>();
    private static final MemoryManager memManager = new MemoryManager();
    private Map<Integer, Integer> processToMemMap = new HashMap<>();

    public ProcessManager() {
    }

    public boolean isPIDValid(int pid) {
        return processMap.containsKey(pid);
    }

    //false meaning cant be killed
    //deal with childs
    public boolean killProcess(int pid) {

        if (!isPIDValid(pid)) return false;

        processMap.get(pid).setRunning(false);
        processMap.remove(pid);
        memManager.deleteData(processToMemMap.get(pid));
        processToMemMap.remove(pid);

        return true;
    }

    public Process createProcess() throws Exception {
        if (memManager.isMemoryFull()) throw new Exception();

        Process process = new Process();

        process.setRunning(true);
        processMap.put(process.getPid(), process);
        int address = memManager.storeData(process.getPid());
        processToMemMap.put(process.getPid(), address);


        return process;
    }


}
