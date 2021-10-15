package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pushthekeypad {
    static int[][] keypad = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 },
            { 3, 0 }, { 3, 1 }, { 3, 2 } };
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[1000];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        while (st.hasMoreTokens()) {
            numbers[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        String hand = br.readLine();
        
        // solution(numbers,hand);
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        int leftpoint = 10;
        int rightpoint = 12;

        for (int i = 0; i < index; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                leftpoint = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                rightpoint = numbers[i];
            } else { // 2,5,8,0
                if (numbers[i] == 0)
                    numbers[i] = 11;

                int pointX = distance(numbers[i], leftpoint);
                int pointY = distance(numbers[i], rightpoint);

                if (pointX > pointY) {
                    sb.append("R");
                    rightpoint = numbers[i];
                } else if (pointX < pointY) {
                    sb.append("L");
                    leftpoint = numbers[i];
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftpoint = numbers[i];
                    } else if (hand.equals("right")) {
                        sb.append("R");
                        rightpoint = numbers[i];
                    }
                }

            }
        }
        answer = sb.toString();
        return answer;
    }

    public static int distance(int numbers, int cur) {
        int nx = Math.abs((keypad[cur - 1][0]) - (keypad[numbers - 1][0]));
        int ny = Math.abs((keypad[cur - 1][1]) - (keypad[numbers - 1][1]));

        return nx + ny;
    }

}
