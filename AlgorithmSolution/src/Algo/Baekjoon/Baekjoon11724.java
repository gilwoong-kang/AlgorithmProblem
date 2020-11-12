package Algo.Baekjoon;

import java.util.*;

public class Baekjoon11724 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(m==0){
            System.out.println(n);
            return;
        }
        Map<Integer,List<Integer>> array = new HashMap<>();
        int[] visit = new int[n+1];
        Queue<Integer> bfs = new ArrayDeque<>();
        int count = 0;

        int f = scanner.nextInt();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(f);
        firstList.add(scanner.nextInt());
        array.put(f,firstList);
        bfs.add(f);
        count++;
        if(m==1){
            System.out.println(n-1);
            return;
        }
        for(int i =1;i<m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(array.containsKey(a)) array.get(a).add(b);
            else{
                List<Integer> newList = new ArrayList<>();
                newList.add(a);
                newList.add(b);
                array.put(a,newList);
            }
            if(array.containsKey(b)){
               array.get(b).add(a);
            }
            else{
                List<Integer> newList = new ArrayList<>();
                newList.add(a);
                newList.add(b);
                array.put(b,newList);
            }
        }
        int currentPointer = bfs.peek();
        loop:
        while(!bfs.isEmpty()){
            int i = bfs.poll();
            visit[i] = 1;
            if(array.containsKey(i)){
                List<Integer> list = array.remove(i);
                for(int j : list){
                    if(visit[j] != 1) bfs.add(j);
                }
            }
            if(bfs.isEmpty()){
                for(int j = currentPointer;j<visit.length;j++){
                    if(visit[j] == 0){
                        count++;
                        bfs.add(j);
                        continue loop;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
