package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1167 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Map<Integer,Integer>> tree = new HashMap<>();
        int first = -1;
        for(int i = 0;i<n;i++){
            Map<Integer,Integer> v = new HashMap<>();
            int num = scanner.nextInt();
            int j = 0;
            while(true){
                j = scanner.nextInt();
                if(j == -1) break;
                v.put(j,scanner.nextInt());
            }
            if(first == -1) first = num;
            tree.put(num,v);
        }
        int deep = cal(tree,first,0)[1];
        System.out.println(cal(tree,deep,0)[0]);
    }
    public static int[] cal(Map<Integer,Map<Integer,Integer>> tree,int key,int except){
        Map<Integer,Integer> current = tree.get(key);
        int currentSum = 0;
        int deepNum = 0;
        if(current.size() == 1 && current.containsKey(except)){
            int[] result = new int[2];
            result[0] = current.values().iterator().next();
            result[1] = key;
            return result;
        }
        for(int i : current.keySet()){
            if(i != except){
                int[] r = cal(tree,i,key);
                if(r[0] > currentSum){
                    currentSum = r[0];
                    deepNum = r[1];
                }
            }
        }
        if(except==0){
            int[] r = new int[2];
            r[0] = currentSum;
            r[1] = deepNum;
            return r;
        }
        else{
            int[] r = new int[2];
            r[0] = currentSum + tree.get(except).get(key);
            r[1] = deepNum;
            return r;
        }
    }
}
