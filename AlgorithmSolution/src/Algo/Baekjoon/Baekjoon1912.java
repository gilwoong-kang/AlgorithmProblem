package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon1912 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        for(int i =0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[n+1];
        dp[0] = 0;

        int i = 0;
        int max = arr[i];
        int current = arr[i];
        int index = 0;
        for(int j =i+1;j<n;j++){
            current = Math.max(arr[j]+current,arr[j]);
            if(max<current){ max = current; index = j;}
        }
        dp[i] = max;

        int result = -100000000;
        for(int j=0;j<n ; j++){
            if(result<dp[i]) result = dp[i];
        }
        System.out.println(result);

    }
}
