package Algo.etc;

import java.util.*;

public class Algo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n  = scanner.nextInt();
        List list = new ArrayList();

        for(int i = 0; i<n ;i++){
            int x = scanner.nextInt();
            if(x != 0 ) list.add(x);
            else{
                if(list.isEmpty()){ System.out.println(0);}
                else{
                    Iterator<Integer> iter = list.iterator();
                    int origin;
                    int lownum = 0;
                    int low = 0;
                    int com;
                    while(iter.hasNext()){
                        origin = iter.next();
                        // 숫자 넣기
                        if(origin < 0 ){ com = origin * -1; }else{ com = origin; }
                        // 비교
                        if(low != 0 && com > low) continue;
                        if(low == 0){
                            low = com;
                            lownum = origin;
                        }else{
                            if(low > com){
                                low = com;
                                lownum = origin;
                            }else if(low == com){
                                if(origin < 0) lownum = origin;
                            }
                        }
                    }
                    list.remove(list.indexOf(lownum));
                    System.out.println(lownum);

                }
            }
        }
    }
}
