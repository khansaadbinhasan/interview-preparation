package CTCI.bitManipulation;

public class Q2BinaryToString {

    public static void main(String[] args) {
        new Q2BinaryToString().run();
    }

    public void run(){

//        System.out.println(Double.doubleToLongBits(1));

        System.out.println(binaryToString(0.625));
    }

    public String binaryToString(double num){
        StringBuilder binary = new StringBuilder("0.");

        int bitNumber = 0;

        while( num != 0 ){

//            System.out.println(binary);
//            System.out.println(num);

            if( bitNumber++ >= 32 ) return "ERROR";

            num = num * 2;

            if( num >= 1 ) {
                num--;
                binary.append(1);
            }

            else binary.append(0);
        }

        return binary.toString();
    }

}
