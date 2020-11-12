package Algo.Baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon7565 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<Pair> bfs = new ArrayDeque<>();

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] array = new int[n+1][m+1];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int x = scanner.nextInt();
                array[i][j] = x;
                if(x == 1){ bfs.add(new Pair(i,j));}
            }
        }
        int result = 0;
        Queue<Pair> emptyQueue = new ArrayDeque<>();
        while(!bfs.isEmpty() || !emptyQueue.isEmpty()){
            Pair p = bfs.poll();
            if(p.left -1 >=0 && array[p.left-1][p.right] != 1 && array[p.left-1][p.right] != -1){
                emptyQueue.add(new Pair(p.left-1,p.right));
                array[p.left-1][p.right] = 1;
            }
            if(p.left +1 <=n-1 && array[p.left+1][p.right] != 1&& array[p.left+1][p.right] != -1){
                emptyQueue.add(new Pair(p.left+1,p.right));
                array[p.left+1][p.right] = 1;
            }
            if( p.right -1 >=0 && array[p.left][p.right-1] != 1 && array[p.left][p.right-1] != -1){
                emptyQueue.add(new Pair(p.left,p.right-1));
                array[p.left][p.right-1] = 1;
            }
            if(p.right +1 <=m-1 && array[p.left][p.right+1] != 1&& array[p.left][p.right+1] != -1){
                emptyQueue.add(new Pair(p.left,p.right+1));
                array[p.left][p.right+1] = 1;
            }
            if(bfs.isEmpty()){
                result++;
                while(!emptyQueue.isEmpty()){ bfs.add(emptyQueue.poll());}
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(array[i][j]!=1 && array[i][j]!=-1){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result-1);
    }
    public static class Pair{
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
