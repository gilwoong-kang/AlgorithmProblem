package Algo.Baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon11399 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i =0;i<n;i++){
            pq.add(scanner.nextInt());
        }
        int sum = 0;
        int result = 0;
        for(int i =0;i<n;i++){
            sum += pq.poll();
            result += sum;
        }
        System.out.print(result);
    }
}
