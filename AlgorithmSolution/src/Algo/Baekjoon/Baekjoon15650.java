package Algo.Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon15650 {
    static int m;
    static int n;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        List<Integer> l = new ArrayList<>();
        for(int i =0;i<n;i++){
            l.add(i+1);
        }
        cal(new StringBuilder(),l,1);
    }
    public static void cal(StringBuilder r, List<Integer> list, int level){
        if(level == m){
            for(int a : list){
                System.out.println(r.toString()+ a);
            }
            return;
        }
        int j = n-level;
        for(int i = 0;i<j;i++){
            if(!list.isEmpty()){
                int a = list.remove(0);
                StringBuilder s = new StringBuilder(r);
                s.append(a).append(" ");
                List<Integer> l = new ArrayList<>();
                l.addAll(list);
                cal(s,l,level+1);
            }
        }
    }
}
