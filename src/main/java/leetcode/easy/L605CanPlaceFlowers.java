package leetcode.easy;

//[1,0,0,0,1]
//1
//[1,0,0,0,1]
//2
//[1,0,0,0,0,0,0,0,0,0,0,0,0,1]
//6
//[1,0,0,0,0,0,0,0,0,0,0,0,0,1]
//5
//[1,0,0,0,0,0,0,0,0,0,0,0,0,1]
//7
//[0]
//1
//[1]
//1
public class L605CanPlaceFlowers {

    public static void main(String[] args) {
        new L605CanPlaceFlowers().run();
    }

    public void run(){
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,1}, 7));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int[] flowers = new int[flowerbed.length+2];

        for( int i = 0; i < flowerbed.length; i++ ){
            flowers[i+1] = flowerbed[i];
        }

        int count = 0;

        for( int i = 1; i < flowers.length-1; i++ ){
            if( flowers[i-1] == 0 && flowers[i+1] == 0 && flowers[i] == 0 ) {
                count++;
                flowers[i] = 1;
            }
        }

        return count >= n;
    }

}
