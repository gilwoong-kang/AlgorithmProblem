package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1932 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = Integer.valueOf(scanner.nextLine());

        // 이중리스트
        List<List> list = new ArrayList<List>();
        for(int i = 0; i<m ; i++){
            List<Integer> slist = new ArrayList<Integer>();
            String s =scanner.nextLine();
            for(String s1 : s.split(" ")){
                slist.add(Integer.valueOf(s1));
            }
            list.add(slist);
        }
        for(int i = 1; i<list.size();i++){
            comparable(list.get(i-1),list.get(i));
        }
        int result = 0;
        for(Object a : list.get(list.size()-1)){
            if(result<(Integer)a) result = (Integer)a;
        }
        System.out.println(result);
    }

    public static void comparable(List<Integer> a, List<Integer> b){
        for(int i = 0;i<b.size();i++){
            if(i == 0){
                b.set(0,b.get(0)+a.get(0));
            }else if(i == b.size()-1){
                b.set(b.size()-1,b.get(b.size()-1) + a.get(a.size()-1));
            }
            else{
                if(a.get(i-1) > a.get(i)){
                    b.set(i,b.get(i) + a.get(i-1));}
                 else{b.set(i,b.get(i) + a.get(i));}
            }
        }
    }
}
