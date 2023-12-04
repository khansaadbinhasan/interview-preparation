package interviews.flipkartSDE1.practice.processMem;


//implement a memory management system which should be capable to-
// allocate memory to processes,
// create a child process &
// kill the process

//Process
//MemoryManager
//Memory

import interviews.flipkartSDE1.practice.processMem.models.Process;
import interviews.flipkartSDE1.practice.processMem.services.ProcessManager;

import java.util.*;
public class FlipkartPracticeMachineCodingSDE1 {


    public static void main(String[] args) throws Exception {
        ProcessManager processManager = new ProcessManager();

        Process process = processManager.createProcess();

        Process p2 = processManager.createProcess();

        System.out.println(process);
        System.out.println(p2);

        processManager.killProcess(p2.getPid());
    }

}




