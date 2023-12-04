package interviews.swiggySDET;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given a string s, find the first non-repeating character in it and
// return its index. If it does not exist, return -1.
//
//Example 1:
//Input: s = “swiggy”
//Output: 0
//Example 2:
//Input: s = ”testing”
//Output: 1
//Example 3:
//Input: s = "aabb"
//Output: -1

//"AAbbbcccccccd-10988+=//4"
//"AAbbbcccccccd-10988+=//"

public class SwiggySDETNov27_2021Round1 {

    public static void main(String[] args) {
        new SwiggySDETNov27_2021Round1().run();
    }

    public void run(){
        //min heap
        System.out.println(indexOfNonRepeating("swiggy"));
    }

    //    'swiggy'
    public int indexOfNonRepeating(String s){

        int[] freqArr = new int[256];

        Arrays.fill(freqArr, 0);

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if( freqArr[s.charAt(i)-'a'] == 1 ) return i;
        }

//        for( int i = 0; i < freqArr.length; i++ ){
//            if( freqArr[i] == 1 ) set.add((char)('a'+i));
//        }
//
//        for( int i = 0; i < s.length(); i++ ){
//            if( set.contains(s.charAt(i)) ) return i;
//        }

        return -1;
    }

    public String indexOfNonRepeating(Integer s){
        return "-1";
    }

//    public String indexOfNonRepeating(Integer s){
//        return -1;
//    }

        //overloading
        //same names functions
        //but different signatures
        //possible

        //overriding
        //inherit
        //provide a new implementation for parent class function
        //not possible

        //defect
        //bug

        //production -- dev
        //testing
        //bug

        //released
        //defect

        //automatino tsting with jmeter, postman
        //jsr223 --> groovy
        //scripts
        //code and message
        //structure //validate json structure
        //value //validate json values

        //GET //get data
        //POST //json body --> creating some data
        //PUT //update data --> posts that
        //DELETE
        //PATCH //update dat --> more efficient

//    {
//        a:"a"
//        b:"b"
//    }

        //retesting

        //automation -> run our regression suite


//    @Override
}


//login page
//username
//password
//login button
//forgot password

//1. whether we are able to access login page
//2. login with correct username and password
//3. should not able login with incorrect username
//4. should not able login with incorrect password
//5. empty password not login
//6. click login button, we get access only to what we should have
//7. forgot password --> security --> should only come to our email
//once it is reset it should also mail that its reset



//on ui
//the password should be invisible by default(hidden)
//there should be some way to hide it
//if we provide wrong credentials then it should show some error message
//And it should point username, password(labels)
//if in requirement (username is shown in form)
//show password is there or not
//login button should be disabled if not filled username, password correctly
//the username should be according to format point out ui only
//should be able to see proper username
//back button should take to correct location



//load testing --> 2000 users should be able to access at once
//the password should not be stored in plain text.(encoding)
//data should be encoded
//It should run on supported browsers/devices(android, iphone)
//It should work for all supported resolutions
//It should be able to run for long time(24h) --> change behavior //reliable
//load time should me minimal(2s) response time
//if server is down, it should give appropriate warning



