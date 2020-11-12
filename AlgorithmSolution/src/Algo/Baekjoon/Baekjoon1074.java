package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon1074 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int N = 1;
        for(int i = 0;i<n;i++){
            N = N*2;
        }
        int count = 0;
        int startxpointer = 0;
        int startypointer = 0;
        int xpointer = N;
        int ypointer = N;
        for(int i = 0;i<n-1;i++){
            if((xpointer + startxpointer)/2 <= x){
                count += (ypointer-startypointer) * (xpointer - startxpointer)/2;
                startxpointer = (xpointer + startxpointer)/2;
            }else{
                xpointer = (xpointer + startxpointer)/2;
            }
            if((ypointer + startypointer)/2 <= y){
                count += ((ypointer - startypointer) / 2) * (xpointer - startxpointer);
                startypointer = (ypointer + startypointer)/2;
            }else{
                ypointer = (ypointer + startypointer)/2;
            }
        }

        for(int i = startxpointer;i<xpointer;i++){
            for(int j = startypointer;j<ypointer;j++){
                if(x == i && y == j){
                    System.out.println(count);
                    return;
                }
                count++;
            }
        }
    }
}
