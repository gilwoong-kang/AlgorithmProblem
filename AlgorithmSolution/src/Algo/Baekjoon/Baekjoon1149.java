package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1149 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        scanner.nextLine();
        PriorityQueue<Pair> priorityA = new PriorityQueue<>();
        for(int i = 0;i<m;i++){
            String[] num = scanner.nextLine().split(" ");
            int index = 0;
            if(priorityA.isEmpty()){
                for(String s : num){
                    priorityA.add(new Pair(Integer.valueOf(s),index++));
                }
                continue;
            }
            PriorityQueue<Pair> priorityB = new PriorityQueue<>();
            int ss = priorityA.size();
            for(int j = 0;j<ss;j++){
                Pair v = priorityA.poll();
                for(String s : num){
                    if(v.index != index){
                        priorityB.add(new Pair(v.value + Integer.valueOf(s),index));
                    }
                index++;
                }
                index = 0;
            }
            for(Pair p : priorityB){
                priorityA.offer(p);
                if(priorityA.size() > 100) break;
            }
            priorityB.clear();
        }
        System.out.println(priorityA.poll().value);
    }

    public static class Pair implements Comparable<Pair>{
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return (value < o.value) ? -1 : 1;
        }
    }
}
