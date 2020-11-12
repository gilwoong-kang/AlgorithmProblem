package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon11054 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[n+1];
        int[] rdp = new int[n+2];
        dp[0] = 1;
        rdp[n-1] = 1;
        boolean up = true;
        for(int i = 1;i<n;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(arr[j]<arr[i] && dp[j]>=dp[i]) dp[i] = dp[j] + 1;
            }
        }
        for(int i = n-2;i>=0;i--){
            rdp[i] = 1;
            for(int j = n-1;j>i;j--){
                if(arr[j]<arr[i] && rdp[j]>=rdp[i]) rdp[i] = rdp[j] + 1;
            }
        }
        for(int i = 1;i<=n;i++){
            dp[i] += rdp[i] -1;
        }
        int result = 0;
        for(int i : dp){
            if(result < i) result = i;
        }
        System.out.println(result);
    }
}
