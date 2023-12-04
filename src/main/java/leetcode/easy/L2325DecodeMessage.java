package leetcode.easy;

//121
//-121
//10
//-101
//0
//-2147483647
//2147483646
public class L2325DecodeMessage {

    public String decodeMessage(String key, String message) {

        char[] keyValPair = new char[26];
        char alp = 'a';

        for( int i = 0; i < key.length(); i++ ){
            if( key.charAt(i) != ' ' ){
                if( keyValPair[key.charAt(i)-'a'] == 0 ){
                    keyValPair[key.charAt(i)-'a'] = alp;
                    alp = (char)(alp + 1);
                }
            }
        }

        String decodedMessage = "";

        for( int i = 0; i < message.length(); i++ ){
            if( message.charAt(i) != ' ' ){
                decodedMessage += keyValPair[message.charAt(i)-'a'];
            } else{
                decodedMessage += " ";
            }
        }

        return decodedMessage;
    }
}
