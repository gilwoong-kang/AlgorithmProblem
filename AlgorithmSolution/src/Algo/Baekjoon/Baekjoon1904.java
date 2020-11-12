package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon1904 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        long a = 1;
        long b = 2;
        for(int i = 2;i<m;i++){
            long x = (a + b) % 15746;
            a = b;
            b = x;
        }
        if(m == 1) System.out.println(1);
        else if(m == 2) System.out.println(2);
        else{
            System.out.println(b);
        }
    }
}
