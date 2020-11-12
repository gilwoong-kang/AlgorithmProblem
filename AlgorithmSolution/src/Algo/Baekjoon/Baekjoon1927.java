package Algo.Baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1927 {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        for(int i = 0; i<m;i++){
            int n = scanner.nextInt();
            if(n != 0){
                priorityQueue.offer(n);
            }else{
                if(priorityQueue.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                System.out.println(priorityQueue.remove());
            }
        }
    }
}
