package interviews.flipkartSDE1.practice.processMem.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MemoryManager {
    //autogenerated -> usually annotation
    private static final int MIN_ADDRESS = 1000;
    private static final int MAX_ADDRESS = 9999;
    private static final int FREE_MEMORY = Integer.MAX_VALUE;
    private static final int ADDRESS_OUT_OF_RANGE = Integer.MIN_VALUE;

    private int address;
    private int data;

    //stores {address: memory}
    private Map<Integer, Integer> memoryMap;
    private LinkedList<Integer> freeMemories;

    public MemoryManager() {
        memoryMap = new HashMap<>();
        freeMemories = new LinkedList<>();

        for (int address = MIN_ADDRESS; address <= MAX_ADDRESS; address++) {
            memoryMap.put(address, FREE_MEMORY);
            freeMemories.add(address);
        }

    }

    public boolean isValidAddress(int address) {
        return memoryMap.containsKey(address);
    }

    //ADDRESS_OUT_OF_RANGE reserved for garbage value, wrong address
    //get data from address
    public int getDataFromAddress(int address) {
        if (!isValidAddress(address)) return ADDRESS_OUT_OF_RANGE;

        return memoryMap.get(address);
    }

    //isMemoryFull -> should be implemented with heap, prirorityQueue
    public boolean isMemoryFull() {
//        for(int key: memoryMap.keySet()){
//            if(memoryMap.get(key) == FREE_MEMORY) return false;
//        }

        return freeMemories.isEmpty();
    }

    //store data -> returns false if data storage not possible, else true
    //should have an exception of its own
    public int storeData(int data) {
        if (isMemoryFull()) return -1;

        int address = freeMemories.getLast();

        memoryMap.put(address, data);

        freeMemories.removeLast();

        return address;
    }

    //returns false if address is invalid, else removes and returns true
    public boolean deleteData(int address) {
        if (!isValidAddress(address)) return false;

        memoryMap.put(address, FREE_MEMORY);
        freeMemories.add(address);

        return true;
    }

    //get address from memory object
//    public int getAddressFromMemory(Memory memory){
//        return memory.getAddress();
//    }
}
