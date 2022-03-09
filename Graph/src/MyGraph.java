
public class MyGraph {

    int n;
    int[][] a;
    char[] v;

    MyGraph() {
        v = "ABCDEFGHIJKLM".toCharArray();
    }

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(v[i] + ": ");
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 99) {
                    System.out.print(v[j] + " ");
                }
            }
            System.out.println();
        }
    }

    void visit(int i) {
        System.out.print(v[i] + " ");
    }

    void breadth() {
        int k = 0;
        MyQueue q = new MyQueue();
        boolean[] enqueued = new boolean[n];
        int i, j;
        for (i = 0; i < n; i++) {
            enqueued[i] = false;
        }
        q.enqueue(k);
        enqueued[k] = true;
        int r;
        System.out.println("\nBreadth-first traverse from the vertex " + v[k] + ":");
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (j = 0; j < n; j++) {
                if (!enqueued[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    enqueued[j] = true;
                }
            }
        }
        System.out.println();
    }

    void depth(boolean[] vis, int i) {
        visit(i);
        vis[i] = true;
        for (int j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] !=99) {
                depth(vis, j);
            }
        }
    }
    void depth(int k) {
        boolean[] vis = new boolean[n];
        int i, j;
        for (i = 0; i < n; i++) {
            vis[i] = false;
        }
        depth(vis, k);
        for (i = 0; i < n; i++) {
            if (!vis[i]) {
                depth(vis, i);
            }
        }

    }
}
