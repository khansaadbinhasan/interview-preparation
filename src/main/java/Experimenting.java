import java.util.*;


public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run() {

        LinkedList<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q.getLast());
        System.out.println(q.getFirst());
        System.out.println(q.removeFirst());
        System.out.println(q);

        String s = "abcdefgdsjkfhjdashlfkjsdh";
        CharSequence charSequence = s.subSequence(0, 5);

        System.out.println(charSequence);
    }
}



