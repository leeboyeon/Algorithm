package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 문자열압축 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        solution(s);
    }
    public static int solution(String s){
        int answer = 0;
        for(int i=1;i<=s.length()/2;i++){
            String cur = s.substring(0, i);
            int count  = 1;
            for(int j=i;j<s.length();j+=i){
                if(j+i > s.length());
            }
        }
        return answer;
    }
}
