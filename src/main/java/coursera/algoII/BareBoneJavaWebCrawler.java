package coursera.algoII;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BareBoneJavaWebCrawler {


    public void crawl() throws IOException {
        Queue<String> queue = new LinkedList<>();
        Set<String> discovered = new HashSet<>();
        String root = "http://www.princeton.edu";

        queue.add(root);
        discovered.add(root);

        while( !queue.isEmpty() ){
            String v = queue.poll();
            System.out.println(v);

            InputStream in = new InputStream() {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            };

            String input = String.valueOf(in.read());
            String regexp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                String w = matcher.group();
                if( !discovered.contains(w) ){
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }
    }




}
