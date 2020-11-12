package Algo.Baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1697 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] level = new int[100001];
        int[] check = new int[100001];
        Queue<Integer> bfs = new ArrayDeque<>();
        bfs.add(n);
        int result = 1000000;
        while(!bfs.isEmpty()){
            int p = bfs.poll();
            if(p == d && result > level[p]){
                result = level[p];
            }
            if(p-1 >= 0 && check[p-1] != 1){ bfs.add(p-1);check[p-1] = 1;level[p-1] = level[p]+1;}
            if(p+1 <= 100000 && check[p+1] != 1){ bfs.add(p+1);check[p+1] = 1;level[p+1] = level[p]+1;}
            if(p*2 <= 100000 && check[p*2] != 1){ bfs.add(p*2);check[p*2] = 1;level[p*2] = level[p]+1;}
        }
        System.out.println(result);
    }
}
