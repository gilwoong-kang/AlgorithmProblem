package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon1065 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int result = 0;
        loop:
        for(int i = 1;i<=n;i++){
            int num = i;
            int pointer = num % 10;
            num = num/10;
            int next = num % 10;
            int dis = next-pointer;
            while(num>0 && num/10 != 0){
                pointer = next;
                num = num/10;
                next = num%10;
                if(next-pointer != dis) continue loop;
            }
            result++;
        }
        System.out.println(result);
    }
}
