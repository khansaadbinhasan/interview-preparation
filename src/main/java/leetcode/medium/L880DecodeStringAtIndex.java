package leetcode.medium;

public class L880DecodeStringAtIndex {

    public String decodeAtIndex(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if( !isInteger(c) ) sb.append(c);
            else{
                String curr = sb.toString();
                while( (c-'0') > 1 ){
                    if( sb.length() > k-1 ) return String.valueOf(sb.charAt(k-1));
                    sb.append(curr);
                    c--;
                }
            }
        }

        return String.valueOf(sb.charAt(k-1));
    }

    public boolean isInteger(char c){
        return c >= '2' && c <= '9';
    }


    public String decodeAtIndex2(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if( !isInteger(c) ) sb.append(c);
            else{
                // String curr = sb.toString();
                while( (c-'0') > 0 ){
                    if( sb.length() > k-1 ) return String.valueOf(sb.charAt(k-1));
                    k -= sb.length();
                    // sb.append(curr);
                    //k-sb.length() >= 1
                    c--;
                }

//                if( sb.length() > k-1 ) return String.valueOf(sb.charAt(k-1));
                sb = new StringBuilder();
            }
        }

        return String.valueOf(sb.charAt(k-1));
    }

    public boolean isInteger2(char c){
        return c >= '2' && c <= '9';
    }

    public static void main(String[] args) {
        new L880DecodeStringAtIndex().run();
    }

    public String decodeAtIndex3(String s, int k) {

        int total = 0;
        int i = 0;


        while( i < s.length() ){
            StringBuilder sub = new StringBuilder();
            while( i < s.length() && !isNumber(s.charAt(i)) ){
                sub.append(s.charAt(i));
                i++;
            }

//            String sub = sub.substring(0,i);
            int m = sub.length();
            int n = 1;

            StringBuilder nums = new StringBuilder();

            while( i < s.length() && isNumber(s.charAt(i)) ){
                nums.append(s.charAt(i));
                n = n * (s.charAt(i)-'0');
                i++;
            }

            if( nums.length() > 9 ) n = 1000_000_000;

            total = m*n;

            if( total >= k ) return String.valueOf(sub.charAt((k-1)%m));
            k-=total;
        }

        return "";
    }

    private boolean isNumber(char c){
        return c >= '2' && c <= '9';
    }


    public void run(){
//        System.out.println(decodeAtIndex3("leet2code3", 10));
//        System.out.println(decodeAtIndex3("ha22", 5));
//        System.out.println(decodeAtIndex3("a2345678999999999999999", 1));
        System.out.println(decodeAtIndex3("a2345678999999999999999", 1000000000));
    }

}
