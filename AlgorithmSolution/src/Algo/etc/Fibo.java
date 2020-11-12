package Algo.etc;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args){
        long current = 0;
        long before1=1;
        long before2=0;
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        if(m == 0){
            System.out.println(0);
        }
        if(m == 1){
            System.out.println(1);
            return;
        }
        for(int i = 2;i<m+1;i++){
            current = before1 + before2;
            before2 = before1;
            before1 = current;
        }
        System.out.println(current);
    }
}
