package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String trim = input.trim();
        String[] result = trim.split("\\s");
        if (trim.equals("")) {
            System.out.println("0");
        } else {
            System.out.println(result.length);
        }
    }
}
