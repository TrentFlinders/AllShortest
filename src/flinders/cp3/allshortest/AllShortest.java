package flinders.cp3.allshortest;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lewi0146
 */
public class AllShortest {

    public static final int INF = 1000;

    public static void printMatrix(int[][] m) {

        int n = m.length;
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (m[u][v] != INF) {
                    System.out.printf(" %2d", m[u][v]);
                } else {
                    System.out.print("  -");
                }
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] m, String[] labels) {

        int n = m.length;
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (m[u][v] != INF) {
                    System.out.print(" " + labels[m[u][v]]);
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        //String[] labels = {"P","Q","R","S"};
        //int[][] D = {{0,2,4,INF},{INF,0,2,6},{1,4,0,1},{INF,1,2,0}};
        //int[][] P = {{INF,INF,INF,INF},{INF,INF,INF,INF},{INF,INF,INF,INF},{INF,INF,INF,INF}};
        //int u = 0;
        //int n = labels.length;

        String fName = "data/tut07.txt";
        Scanner fS = new Scanner(new File(fName));

        String[] labels = fS.nextLine().split(" ");
        int u = 0;
        int n = labels.length;
        // read in graph structure
        int[][] D = new int[n][n];
        int[][] P = new int[n][n];

        // init D and P
        for (u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                D[u][v] = INF;
                P[u][v] = INF;
            }
        }

        u = 0;
        while (fS.hasNext()) {
            Scanner lS = new Scanner(fS.nextLine());

            while (lS.hasNext()) {
                // pais of adj and weight
                int v = lS.nextInt();
                int w = lS.nextInt();
                D[u][v] = w;
                P[u][v] = v;
            }
            u++;
        }

        for (u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (D[u][v] != INF) {
                    P[u][v] = v;
                }
            }
        }

        System.out.println("0-path");
        System.out.println("D");
        printMatrix(D);
        System.out.println("P");
        printMatrix(P, labels);

        for (int k = 0; k < n; k++) {
            System.out.println(k + 1 + "-path with " + labels[k]);

            for (u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    System.out.print("checking: " + labels[u] + "->" + labels[v] + " = " + D[u][v]
                            + ", " + labels[u] + "->" + labels[k] + "->" + labels[v] + " = " + (D[u][k] + D[k][v]));
                    if (D[u][k] + D[k][v] < D[u][v]) {
                        //System.out.println("Shorter Path: " labels[u] + " -> " )
                        D[u][v] = D[u][k] + D[k][v];
                        P[u][v] = k;
                        System.out.print("  shorter path!");
                    }
                    System.out.println();
                }
            }

            System.out.println("D");
            printMatrix(D);
            System.out.println("P");
            printMatrix(P, labels);
        }

        System.out.println("Final Path Matrix");
        printMatrix(P, labels);
    }
}
