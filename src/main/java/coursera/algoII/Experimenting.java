package coursera.algoII;

import coursera.algoII.datastructures.Graph;

import java.io.IOException;
import java.io.InputStream;

public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run(){
        InputStream in = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        Graph G = new Graph(in);

        for (int v = 0; v < G.V(); v++) {
            for (int w: G.adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
    }
}
