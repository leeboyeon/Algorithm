package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1068_Tree {
    static int N;
    static boolean[] visit;
    static int[] parent;
    static ArrayList<Integer> child[];
    static int delete;
    static int count, root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[N];
        child = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<Integer>();
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == -1) {
                root = i;
                parent[i] = i;
            } else {
                parent[i] = value;
                child[value].add(i);
            }
        }
        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);

        System.out.println(count);
    }

    public static void deleteNode(int delete) {
        if (delete == root) {
            count = 0;
            return;
        }
        int dp = parent[delete];
        for (int i = 0; i < child[dp].size(); i++) {
            if (child[dp].get(i) == delete) {
                child[dp].remove(i);
                break;
            }
        }
        countLeaf(root);
    }

    public static void countLeaf(int value) {
        if (child[value].size() == 0) {
            count++;
            return;
        }
        for (int i = 0; i < child[value].size(); i++) {
            countLeaf(child[value].get(i));
        }
    }
}
