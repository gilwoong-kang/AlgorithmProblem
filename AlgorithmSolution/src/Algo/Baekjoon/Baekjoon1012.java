package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon1012 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        for(int x = 0 ;x<testCase;x++){
            int[][] ground = new int[scanner.nextInt()][scanner.nextInt()];
            int n = scanner.nextInt();
            for(int i =0;i<n;i++){
                ground[scanner.nextInt()][scanner.nextInt()] = 1;
            }
            int count = 0;
            for(int q = 0;q<ground.length;q++){
                for(int w = 0;w<ground[q].length;w++){
                    if(ground[q][w] == 1){
                        count++;
                        erase(ground,q,w);
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void erase(int[][] ground,int x,int y){
        if(ground[x][y] == 1){
            ground[x][y] = 0;
            if(x-1>=0) erase(ground,x-1,y);
            if(x+1<ground.length)erase(ground,x+1,y);
            if(y-1>=0)erase(ground,x,y-1);
            if(y+1 < ground[x].length)erase(ground,x,y+1);
        }
    }
}
