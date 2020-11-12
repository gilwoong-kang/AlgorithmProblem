package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon9465 {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i =0;i<t;i++){
            int n = scanner.nextInt();
            int[][] array = new int[2][n];
            for(int j =0;j<2;j++){
                for (int k = 0; k < n; k++) {
                    array[j][k] = scanner.nextInt();
                }
            }
            int big = Math.max(array[0][0],array[1][0]);
            if(n==1){ System.out.println(big);continue;}
            array[0][1] += array[1][0];
            array[1][1] += array[0][0];
            big = Math.max(array[0][1],array[1][1]);
            for (int j = 2; j < n; j++) {
                array[0][j] = Math.max(array[1][j-1],array[1][j-2]) + array[0][j];
                array[1][j] = Math.max(array[0][j-1],array[0][j-2]) + array[1][j];
                int b = Math.max(array[0][j],array[1][j]);
                if(big < b) big = b;
            }
            System.out.println(big);
        }
    }
}
