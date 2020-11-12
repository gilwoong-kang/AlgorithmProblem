package Algo.Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baekjoon15654 {
    static int m;
    static int n;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        List<Integer> l = new ArrayList<>();
        for(int i =0;i<n;i++){
            l.add(scanner.nextInt());
        }
        Collections.sort(l);
        cal(new StringBuilder(),l,1);
    }

    public static void cal(StringBuilder r, List<Integer> l, int level){
        if(level == m){
            for(int a : l){
                System.out.println(r.toString()+ a);
            }
            return;
        }
        int j = n-level+1;
        for(int i = 0;i<j;i++){
            if(!l.isEmpty()){
                List<Integer> list = new ArrayList<>();
                list.addAll(l);
                int a = list.remove(i);
                StringBuilder s = new StringBuilder(r);
                s.append(a).append(" ");
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(list);
                cal(s,list1,level+1);
            }
        }
    }
}
