package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1655 {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueueLess = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueueBetter = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);


        int m = scanner.nextInt();
        for(int  i =0;i<m;i++){
            int n = scanner.nextInt();
            if(priorityQueueLess.isEmpty() && priorityQueueBetter.isEmpty()){
                priorityQueueLess.offer(n);
                System.out.println(n);
                continue;
            }
            if(priorityQueueLess.peek()<n){
                priorityQueueBetter.offer(n);
                if(priorityQueueLess.size()<priorityQueueBetter.size()){
                    priorityQueueLess.offer(priorityQueueBetter.poll());
                }
                System.out.println(priorityQueueLess.peek());
            }else{
                priorityQueueLess.offer(n);
                if(priorityQueueLess.size()>priorityQueueBetter.size()+1){
                    priorityQueueBetter.offer(priorityQueueLess.poll());
                }
                System.out.println(priorityQueueLess.peek());
            }
        }
    }
}
