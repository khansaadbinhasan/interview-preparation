package CTCI.ch8recursionAndDynamicProgramming;

import java.util.*;

public class Q13StackOfBoxes {

    public static void main(String[] args) {
        new Q13StackOfBoxes().run();
    }

    public void run(){
        List<Box> boxes = new LinkedList<>();

        boxes.add(new Box(1,2,3));
        boxes.add(new Box(2,2,3));
        boxes.add(new Box(4,5,6));
        boxes.add(new Box(7,8,9));
        boxes.add(new Box(4,6,5));
        boxes.add(new Box(8,9,7));

        System.out.println(stackOfBoxes(boxes));

        boxes.clear();

        boxes.add(new Box(3, 1,2));
        boxes.add(new Box(4, 2,3));
        boxes.add(new Box(5, 3,4));
        boxes.add(new Box(6, 4,5));

        System.out.println(stackOfBoxes(boxes));
    }

    Map<Box, Integer> boxHeight = new HashMap<>();

    public int stackOfBoxes(List<Box> boxes){
        boxes.sort(Comparator.reverseOrder());
        System.out.println(boxes);

        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            boxes.remove(box);
            int height = stackOfBoxes(boxes, box, box.height);
            maxHeight = Math.max(height,maxHeight);
        }

        return maxHeight;
    }

    class Box implements Comparable<Box> {
        int height;
        int width;
        int depth;

        public Box(int h, int w, int d){
            height = h;
            width = w;
            depth = d;
        }

        @Override
        public int compareTo(Box box){
            return this.width - box.width;
        }

        @Override
        public String toString() {
            return "[height: " + this.height + " width: " + this.width + " depth: " + this.depth + "]";
        }
    }

    public int stackOfBoxes(List<Box> boxes, Box box, int height){
        if( boxHeight.containsKey(box) && height < boxHeight.get(box) ) return boxHeight.get(box);
        int maxHeight = height;

        for (int i = 0; i < boxes.size(); i++) {
            Box box1 = boxes.get(i);
            if( box1.height < box.height && box1.width < box.width && box1.depth < box.depth ){
                boxes.remove(box1);
                maxHeight = Math.max(maxHeight,stackOfBoxes(boxes, box1, height+box1.height));
                boxes.add(box1);
            }
        }

        boxHeight.put(box, maxHeight);
//        if( maxHeight > boxHeight.get(box) ) boxHeight.put(box, maxHeight);

        return maxHeight;
    }

//    public int recurse(List<Box> boxes, int height, Box box){
//        int maxHeight = 0;
//        for (int j = 0; j < boxes.size(); j++) {
//            Box box1 = boxes.get(j);
//            if( box1.height < box.height && box1.width < box.width && box1.depth < box.depth ){
//                maxHeight = Math.max(maxHeight,recurse(boxes, height+box1.height, box));
//            }
//        }
//
//        return maxHeight;
//    }

}
