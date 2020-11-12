package Algo.Baekjoon;

import java.util.*;

public class Baekjoon18870 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> origin = new ArrayList<>();
        int n = scanner.nextInt();
        for(int i = 0;i<n;i++){
            int x = scanner.nextInt();
            if(!map.containsKey(x)){
                map.put(x,0);
                priorityQueue.add(x);
            }
            origin.add(x);
        }
        for(int i = 0;i<map.size();i++){
            map.replace(priorityQueue.poll(),i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i : origin){
            stringBuilder.append(map.get(i)).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
}
