package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon2748 {
    public static void main(String[] args){
        int fibo0 = 0;
        int fibo1 = 1;

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        for(int i = 0;i<m;i++){
            int n = scanner.nextInt();
            if(n == 0){
                System.out.println("1 0");
            }else if(n == 1){
                System.out.println("0 1");
            }else{
                Pair<Integer,Integer> pairA = new Pair<Integer, Integer>(1,0);
                Pair<Integer,Integer> pairB = new Pair<Integer, Integer>(0,1);
                for(int j = 2;j<n+1;j++){
                    Pair<Integer,Integer> newPair = new Pair<Integer, Integer>(
                            pairA.zero+pairB.zero,pairA.one+pairB.one);
                    pairA = pairB;
                    pairB = newPair;
                }
                System.out.println(pairB.zero + " " + pairB.one);
            }
        }
    }

    public static class Pair<zero,one>{
        int zero;
        int one;

        public Pair(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
}
