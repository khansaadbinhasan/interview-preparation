package leetcode.easy;

//"1.1.1.1"
//"255.100.50.0"
public class L1108DefangingIPAddress {

     public String defangIPaddr(String address) {
         return address.replaceAll("\\.","\\[\\.\\]");
     }

}
