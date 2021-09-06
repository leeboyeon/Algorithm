package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1991_트리순회 {
    static int N;
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int root = st.nextToken().charAt(0) - 'A';
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            int left = -1;
            int right = -1;
            if (l != '.') {
                left = l - 'A';
            }
            if (r != '.') {
                right = r - 'A';
            }
            node[root] = new Node(left, right);
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    public static void preOrder(int index) {
        if (index == -1)
            return;
        System.out.print((char) (index + 'A'));
        preOrder(node[index].left);
        preOrder(node[index].right);
    }

    public static void inOrder(int index) {
        if (index == -1)
            return;
        inOrder(node[index].left);
        System.out.print((char) (index + 'A'));
        inOrder(node[index].right);

    }

    public static void postOrder(int index) {
        if (index == -1)
            return;
        postOrder(node[index].left);
        postOrder(node[index].right);
        System.out.print((char) (index + 'A'));
    }
}

class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
