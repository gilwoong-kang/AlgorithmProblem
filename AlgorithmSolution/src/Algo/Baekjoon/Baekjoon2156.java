package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon2156 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] wine = new int[n+1];
        long[] maxValue = new long[n+1];

        for(int i = 1; i<=n;i++){
            wine[i] = scanner.nextInt();
        }
        if(n == 1){System.out.println(wine[1]);return;}
        if(n == 2){System.out.println(wine[1]+wine[2]);return;}
        maxValue[1] = wine[1];
        maxValue[2] = maxValue[1] + wine[2];
        maxValue[3] = Math.max(maxValue[1] + wine[3],wine[2]+wine[3]);

        for(int i = 4; i<=n;i++){
            maxValue[i] = Math.max(Math.max(maxValue[i-2] + wine[i],maxValue[i-3] + wine[i-1] + wine[i]),maxValue[i-4]+wine[i-1]+wine[i]);
        }
        System.out.println(Math.max(maxValue[n],maxValue[n-1]));
    }
}

