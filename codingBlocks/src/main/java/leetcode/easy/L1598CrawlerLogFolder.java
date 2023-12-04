package leetcode.easy;

//["d1/","d2/","../","d21/","./"]
//["d1/","d2/","./","d3/","../","d31/"]
//["d1/","../","../","../"]
public class L1598CrawlerLogFolder {

    public int minOperations(String[] logs) {

        int ops = 0;

        for( String log: logs ){
            if( log.equals("../") ) ops = ops > 0 ? ops-1: 0;
            else if( !log.equals("./") ) ops++;
        }

        return ops;
    }

}
