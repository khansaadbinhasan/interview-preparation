package CTCI.ch8recursionAndDynamicProgramming;

import java.util.*;

public class Q13StackOfBoxes {

    public static void main(String[] args) {
        new Q13StackOfBoxes().run();
    }

    public void run(){
        List<Box> boxes = new LinkedList<>();

        boxes.add(new Box(1,2,3));
        boxes.add(new Box(4,5,6));
        boxes.add(new Box(7,8,9));

        System.out.println(stackOfBoxes(boxes, 0));
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
            if( this.height > box.height && this.width > box.width && this.depth > box.depth ) return 1;


            return -1;
        }
    }

    public int stackOfBoxes(List<Box> boxes, int height){

        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            boxes.remove(box);
            for (int j = 0; j < boxes.size(); j++) {
                Box box1 = boxes.get(j);
                if( box1.height < box.height && box1.width < box.width && box1.depth < box.depth ){
                    maxHeight = Math.max(maxHeight,stackOfBoxes(boxes, height+box.height));
                }
            }
            boxes.add(box);
        }

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
