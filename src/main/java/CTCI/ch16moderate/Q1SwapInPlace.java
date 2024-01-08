package CTCI.ch16moderate;

public class Q1SwapInPlace {

    public static void main(String[] args) {
        new Q1SwapInPlace().run();
    }

    public void run(){
        swap(2,3);
    }

    public void swap(int a, int b){
        System.out.println("a is " + a);
        System.out.println("b is " + b);

        a = a+b;
        b = -(b-a);
        a = a-b;

        System.out.println("a is " + a);
        System.out.println("b is " + b);
    }

}
