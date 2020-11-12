package Algo.Baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon11279 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(m, Collections.reverseOrder());
        for(int i = 0;i<m;i++){
            int n = scanner.nextInt();
            if(n != 0){
                priorityQueue.offer(n);
            }else{
                if(priorityQueue.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                int remove = priorityQueue.remove();
                System.out.println(remove);
            }
        }
    }
}
