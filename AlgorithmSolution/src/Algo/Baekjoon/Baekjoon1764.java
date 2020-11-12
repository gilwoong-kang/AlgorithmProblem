package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1764 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Map<String,Integer> names = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0;i<n+m;i++){
            String name = scanner.nextLine();
            if(!names.containsKey(name)){ names.put(name,1); }
            else{ result.add(name);}
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(String s : result){
            System.out.println(s);
        }
    }
}
