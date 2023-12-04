package misc.advancedRecursion;

public class PermuteString {

    public static void main(String[] args) {
        new PermuteString().run();
    }

    public void run(){

        permute("abc", 0, 2);

    }

    public void permute(String s, int l, int r){

        if( l == r ) {
            System.out.println(s);
            return;
        }

        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            permute(s, l+1, r);
            s = swap(s, l, i);
        }
    }

    public String swap(String s, int l, int r){
        char[] charArr = s.toCharArray();

        char temp = charArr[l];
        charArr[l] = charArr[r];
        charArr[r] = temp;

        return String.valueOf(charArr);
    }

}
