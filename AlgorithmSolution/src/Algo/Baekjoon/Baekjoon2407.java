package Algo.Baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon2407 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if(m < n/2) m = n-m;

        BigInteger nf  = BigInteger.ONE;
        BigInteger mf = BigInteger.ONE;
        for(int i =n;i>m;i--) nf = nf.multiply(BigInteger.valueOf(i));
        for(int i = 1;i<=n-m;i++) mf = mf.multiply(BigInteger.valueOf(i));
        System.out.println(nf.divide(mf).toString());
    }
}
