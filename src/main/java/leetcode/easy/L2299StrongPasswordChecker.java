package leetcode.easy;


import java.util.*;

public class L2299StrongPasswordChecker {

    public static void main(String[] args) {
        new L2299StrongPasswordChecker().run();
    }

    public void run(){
        strongPasswordCheckerII("");
    }

    public boolean strongPasswordCheckerII(String password) {
        return containsLowerCase(password) && containsUpperCase(password) &&
                containsDigit(password) && containsSpecialCharacterer(password) &&
                !containsTwoSameLetters(password) && has8Letters(password);
    }


    public boolean containsLowerCase(String password){
        return !password.toUpperCase().equals(password);
    }

    public boolean containsUpperCase(String password){
        return !password.toLowerCase().equals(password);
    }

    public boolean containsDigit(String password){

        Set<String> nums = new HashSet<>();

        nums.add("0");
        nums.add("1");nums.add("2");nums.add("3");
        nums.add("4");nums.add("5");nums.add("6");
        nums.add("7");nums.add("8");nums.add("9");

        for( String k: password.split("") ){
            if( nums.contains(k) ) return true;
        }

        return false;
    }

    public boolean containsSpecialCharacterer(String password){
        Set<String> specialChars = new HashSet<>();


        specialChars.add("!");specialChars.add("@");specialChars.add("#");
        specialChars.add("$");specialChars.add("%");specialChars.add("^");
        specialChars.add("&");specialChars.add("*");specialChars.add("(");
        specialChars.add(")");specialChars.add("-");specialChars.add("+");


        for( String k: password.split("") ){
            if( specialChars.contains(k) ) return true;
        }

        return false;
    }

    public boolean containsTwoSameLetters(String password){
        for( int i = 1; i < password.length(); i++ ){
            if( password.charAt(i) == password.charAt(i-1) ) return true;
        }

        return false;
    }

    public boolean has8Letters(String password){
        return password.length() >= 8;
    }
}
