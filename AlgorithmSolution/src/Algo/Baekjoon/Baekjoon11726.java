package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon11726 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int first = 1;
        int second = 2;
        int n = scanner.nextInt();
        if(n == 1){
            System.out.print(1);
            return;
        }
        for(int i =2;i<n;i++){
            int r = (first + second) % 10007;
            first = second;
            second = r;
        }
        System.out.print(second);
    }
}
