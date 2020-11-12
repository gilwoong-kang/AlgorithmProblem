package Algo.Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon9251 {
    public static void main(String[] args){
        while(true){

        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("");
        String[] com = scanner.nextLine().split("");

        int[][] dp = new int[1002][1002];
        dp[0][0] = 0;
        for(int i=1;i<com.length+1;i++){
            for(int j = 1;j<=arr.length;j++){
                if(com[i-1].equals(arr[j-1])) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int temp = arr.length;
        int big = dp[com.length][arr.length];
        Stack<String> s = new Stack<>();

        for(int i = com.length;i>=0;i--){
            for(int j = temp-1;j>=0;j--){
                if(dp[i][j] != big){
                    big = dp[i][j];
                    temp = j;
                    s.push(arr[j]);
                }
            }
        }
        System.out.println(s.size());
        }
    }
}
