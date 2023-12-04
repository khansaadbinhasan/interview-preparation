package leetcode.easy;

//2
//100
//1
//50
//1000
//999
//43
//333
public class L1884EggDrop {
    public int twoEggDrop(int n) {
        double bac = Math.sqrt(8*n+1);
        return (int) Math.ceil((bac-1)/2);
    }
}
