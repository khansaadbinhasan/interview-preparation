import java.util.*;


public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run() {
//        String s = "abcdefgdsjkfhjdashlfkjsdh";
//        CharSequence charSequence = s.subSequence(0,5);
//
//        StringBuilder sb = new StringBuilder(s);
//        System.out.println("sb " + sb);
//        System.out.println("sb.delete(1,2) " + sb.delete(1,2));
//        System.out.println("sb.reverse() " + sb.reverse());
//        System.out.println("sb.deleteCharAt(0) " + sb.deleteCharAt(0));
//        System.out.println("sb.indexOf(\"s\") " + sb.indexOf("s"));
//        System.out.println("sb.insert(5,3) " + sb.insert(5,3));
//        System.out.println("sb.lastIndexOf(\"sd\") " + sb.lastIndexOf("sd"));
//        System.out.println("sb.replace(0,2,\"0\") " + sb.replace(0,2,"0"));
//
//        System.out.println(charSequence);

//        Random r = new Random();
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(r.nextInt(5));
//        }


        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3});

        String[] array = {"apple", "banana", "orange"};

        // Convert array to List using Arrays.asList()
        List<String> listFromArray = Arrays.asList(array);

    }

    public void update(int[][] a){
        a[0][0] = -1;
        a[0][1] = -1;
    }

    public int[][] clone(int[][] marked){
        int[][] a = new int[marked.length][marked[0].length];

        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[0].length; j++) {
                a[i][j] = marked[i][j];
            }
        }

        return a;
    }
    }



