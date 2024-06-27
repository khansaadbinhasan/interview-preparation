package leetcode.blind75;

//["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],["sad"],["rad"]]
//["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//["WordDictionary","addWord","addWord","addWord","search","search","search","search","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b......"],["abc"],["..."],["abc"],["abcccc."]]
public class L211WordDictionary {
    class Trie{
        char val;
        Trie[] childs;
        boolean end;

        public Trie(){
            this('Z');
        }

        public Trie(char val){
            this.val = val;
            this.childs = new Trie[26];
            this.end = false;
        }
    }

    Trie root;

    public L211WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for( int i = 0; i < word.length(); i++ ){
            char c = word.charAt(i);
            if( node.childs[c-'a'] == null ) node.childs[c-'a'] = new Trie(c);
            node = node.childs[c-'a'];
        }

        node.end = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, Trie node) {
        for( int i = 0; i < word.length(); i++ ){
            char c = word.charAt(i);
            if( c == '.' ) {
                boolean res = false;
                for( int j = 0; j < node.childs.length; j++ ){
                    if( node.childs[j] != null ){
                        if( i == word.length()-1 && node.childs[j].end ) return true;
                        if( search(word.substring(i+1), node.childs[j]) ) return true;
                    }
                }
                return res;
            }
            if( node.childs[c-'a'] == null ) return false;
            if( node.childs[c-'a'].end && i == word.length()-1 ) return true;

            node = node.childs[c-'a'];
        }

        return false;
    }

    public static void main(String[] args) {
        new L211WordDictionary().run();
    }

    public void run(){
        L211WordDictionary wordDictionary = new L211WordDictionary();

//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        wordDictionary.addWord("pad");
//        wordDictionary.addWord("bad");
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search("b.."));

        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("aa"));

    }

}
