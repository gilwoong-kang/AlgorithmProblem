package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon9461 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        for(int i = 0;i<m;i++){
            int n = scanner.nextInt();
            if( n < 4){
                System.out.println(1);
                continue;
            }
            if(n<6){
                System.out.println(2);
                continue;
            }
            long r = 0;

            long o = 1;
            long t = 1;
            long th = 1;
            long f = 2;
            long fi = 2;

            for(int j = 5;j<n;j++){
                r = fi + o;
                o = t; t = th; th = f; f = fi; fi = r;
            }
            System.out.println(r);
        }
    }
}
