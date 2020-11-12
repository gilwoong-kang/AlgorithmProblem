package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon2565 {
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[501];
        int longest = 0;
        for(int i =0;i<n;i++){
            int value = scanner.nextInt();
            int index = scanner.nextInt();
            if(longest < index) longest = index;
            arr[index] = value;
        }
        int[] dp=new int[501];
        dp[0]=1;

        for(int i = 1;i<longest+1;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(arr[i]>arr[j] && dp[i] <= dp[j]) dp[i] = dp[j]+1;
            }
        }
        int result =0;
        for(int a : dp){
            if(a>result) result = a;
        }
        System.out.println(n-result+1);



    }
}
