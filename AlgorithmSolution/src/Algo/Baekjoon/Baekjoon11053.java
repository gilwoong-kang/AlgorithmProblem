package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon11053 {
    static int[] num;
    static int[] dp;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        num = new int[1001];
        dp = new int[1001];
        for(int i = 0; i<n;i++){
            num[i] = scanner.nextInt();
        }
        dp[0] = 1;
        for(int i =1;i<n;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(num[i]>num[j] && dp[i] <= dp[j]) dp[i] = dp[j]+1;
            }
        }
        int max = 0;
        for(int i : dp){
            if(max<i) max = i;
        }
        System.out.println(max);
    }
}
