package CodingTEST;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class sk4 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 } };
        solution(n, edges);
    }

    public static long solution(int n, int[][] edges) {
        long answer = 0;
        int[][] graph = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        Set<Pair> hash = new HashSet<>();
        for (int via = 0; via < n; via++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    if ((from != via) && (from != to) && (via != to)) {
                        if (graph[from][via] + graph[via][to] == graph[from][to]) {
                            hash.add(new Pair(from, via, to));
                            boolean check = checkDupli(hash, from, to, via);
                            // answer++;
                        }
                    }

                }
            }
        }
        System.out.println(hash.size());
        answer = hash.size();
        return answer;

    }

    public static boolean checkDupli(Set hash, int from, int to, int via) {
        Iterator<Pair> it = hash.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return false;
    }
}

class Pair {
    int from;
    int via;
    int to;

    public Pair(int from, int via, int to) {
        this.from = from;
        this.via = via;
        this.to = to;
    }

    public String toString() {
        return from + " " + via + " " + to;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair p = (Pair) obj;
            if (this.from == p.from && this.to == p.to) {
                return true;
            }
        }
        return false;
    }
}