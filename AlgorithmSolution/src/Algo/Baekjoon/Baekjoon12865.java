package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon12865 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int limit = scanner.nextInt();
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        for(int i=0;i<n;i++){
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        int[] dp = new int[n+1];
        for(int i = 0;i<n;i++){
            dp[i] = 0;
            int sumwwight = 0;
            for(int j=i;j<n;j++){
                if(sumwwight+weight[j]<=limit){
                    dp[i] = dp[i] + value[j];
                    sumwwight += weight[j];
                }else{
                    if(dp[i] < value[j]){
                        if(weight[j]<limit){
                            dp[i] = value[j];
                            sumwwight = weight[j];
                        }
                    }
                }
            }
        }
        int result = 0;
        for(int i=0;i<n;i++){
            if(result < dp[i]) result = dp[i];
        }
        System.out.println(result);
    }
}
