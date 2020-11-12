package Algo.Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon10844 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Long> list = new ArrayList<Long>();
        int MOD = 1000000000;
        int m = scanner.nextInt();
        long[][] dp = new long[m+1][11];
        for(int i =1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i =2;i<=m;i++){
            for(int j=0;j<=9;j++){
                if(j == 0) dp[i][j] = dp[i-1][j+1];
                else if(j == 9) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                dp[i][j] = dp[i][j]%MOD;
            }
        }
        long result = 0;
        for(long l : dp[m]){
            result += l;
        }
        System.out.println(result%1000000000);
    }
}
