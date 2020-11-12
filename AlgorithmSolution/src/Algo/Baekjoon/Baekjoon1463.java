package Algo.Baekjoon;

import java.util.Scanner;
public class Baekjoon1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int [1000001];
        arr[1] = 0;
        arr[2] = arr[3] = 1;

        for (int i = 2 ; i <= N ; i++) {
//            if (i%6 == 0){
//                arr[i] = Math.min(arr[i/3], arr[i/2]) + 1;
//                arr[i] = arr[i-1] + 1;
//            }
            arr[i] = arr[i-1] + 1;
            if (i%2 == 0)
                arr[i] = Math.min(arr[i/2], arr[i-1]) + 1;
            if (i%3 == 0){
                arr[i] = Math.min(arr[i/3], arr[i-1]) + 1; }
        }
        System.out.println(arr[N]);
    }
}