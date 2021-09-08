package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj5639_이진검색트리 {
    static ArrayList<Integer> preorderTree;
    static ArrayList<Integer> postorderTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preorderTree = new ArrayList<>();

        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            preorderTree.add(Integer.parseInt(str));
        }
        toPostOrderTree(0, preorderTree.size() - 1);
    }

    public static void toPostOrderTree(int start, int end) {
        if (start > end)
            return;
        int root = preorderTree.get(start);
        int right = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (root < preorderTree.get(i)) {
                right = i;
                break;
            }
        }
        toPostOrderTree(start + 1, right - 1);
        toPostOrderTree(right, end);
        System.out.println(root);
    }
}
