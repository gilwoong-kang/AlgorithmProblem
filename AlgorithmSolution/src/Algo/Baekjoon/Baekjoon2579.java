package Algo.Baekjoon;

import java.util.*;

public class Baekjoon2579 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] stair = new int[m+1];
        long[] maxValue = new long[m+1];

        for(int i = 1;i<=m;i++){
            stair[i] = scanner.nextInt();
        }
        maxValue[1] = stair[1];
        if(m>1){
            maxValue[2] = stair[1] + stair[2];
            if(m>2){
                maxValue[3] = Math.max(stair[1],stair[2]) + stair[3];
                if(m>3){
                    for(int i = 4;i<=m;i++){
                        maxValue[i] = Math.max(maxValue[i-3]+stair[i-1],maxValue[i-2]) + stair[i];
                    }
                }
            }
        }
        System.out.println(maxValue[m]);
    }
}
