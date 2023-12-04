package codingBlocks.stacksAndQueues;

import java.util.*;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        new RemoveDuplicateLetters().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        String inpStr = sc.next();
        System.out.println(removeDuplicateLetters(inpStr));
    }

    public String removeDuplicateLetters(String s) {
        int numAlphas = 26;
        int[] lastCharIndices = new int[numAlphas];

        Arrays.fill(lastCharIndices, -1);

        char[] duplicateCharArr = s.toCharArray();

        for (int i = duplicateCharArr.length - 1; i >= 0 ; i--)
            if( lastCharIndices[duplicateCharArr[i] - 'a'] == -1 )
                lastCharIndices[duplicateCharArr[i] - 'a'] = i;

        Stack<Character> charStack = new Stack<>();
        boolean[] containsArr = new boolean[numAlphas];

        Arrays.fill(containsArr, false);

        for (int i = 0; i < duplicateCharArr.length; i++) {

            while( !charStack.empty() &&
                        duplicateCharArr[i] < charStack.peek() &&
                        lastCharIndices[charStack.peek() - 'a'] > i &&
                        !containsArr[duplicateCharArr[i] - 'a']
                )
            {
                containsArr[charStack.peek() - 'a'] = false;
                charStack.pop();
            }

            if( !containsArr[duplicateCharArr[i] - 'a'] ) {
                charStack.push(duplicateCharArr[i]);
                containsArr[duplicateCharArr[i] - 'a'] = true;
            }

        }

        StringBuilder uniqueString = new StringBuilder();

        for( char c: charStack ) uniqueString.append(c);

        return uniqueString.toString();
    }


}








//    public String removeDuplicateLetters(String s) {
//        int numAlphas = 26;
//        int[] lastCharIndices = new int[numAlphas];
//
//        Arrays.fill(lastCharIndices, -1);
//
//        char[] duplicateCharArr = s.toCharArray();
//
//        for (int i = duplicateCharArr.length - 1; i >= 0 ; i--) {
//            int charIntVal = duplicateCharArr[i] - 'a';
//            if( lastCharIndices[charIntVal] == -1 ) lastCharIndices[charIntVal] = i;
//        }
//
//        Stack<Character> charStack = new Stack<>();
//        boolean[] containsArr = new boolean[numAlphas];
//
//        Arrays.fill(containsArr, false);
//
//        for (int i = 0; i < duplicateCharArr.length; i++) {
//
//            if( !charStack.empty() ){
//
//                int peekIndex = charStack.peek() - 'a';
//                int indexInLastCharOfTopStack = lastCharIndices[peekIndex];
//
//                while( duplicateCharArr[i] < charStack.peek() &&
//                        (indexInLastCharOfTopStack > i) ){
//
//                    charStack.pop();
//                    containsArr[peekIndex] = false;
//
//                    if( charStack.isEmpty() ) break;
//
//                    peekIndex = charStack.peek() - 'a';
//                    indexInLastCharOfTopStack = lastCharIndices[peekIndex];
//                }
//
//            }
//
//            if( !containsArr[duplicateCharArr[i] - 'a'] ) {
//                charStack.push(duplicateCharArr[i]);
//                containsArr[duplicateCharArr[i] - 'a'] = true;
//            }
//
////            System.out.println(charStack.toString());
//
//        }
//
//        StringBuilder uniqueString = new StringBuilder();
//
//        for( char c: charStack ) uniqueString.append(c);
//
//        return uniqueString.toString();
//    }
