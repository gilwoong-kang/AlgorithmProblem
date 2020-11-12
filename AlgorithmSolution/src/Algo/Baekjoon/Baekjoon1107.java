package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1107 {
    static List<Integer> button = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int channel = scanner.nextInt();
        int n = scanner.nextInt();
        if(n == 10){
            int result = channel>100 ? channel - 100 : 100 - channel;
            System.out.println(result);
            return;
        }
        int[] t = new int[10];
        if(n != 0){ for(int i =0;i<n;i++ ){ t[scanner.nextInt()] = 1; }}
        for(int i = 0;i<10;i++) if(t[i]!=1) button.add(i);
        if(channel == 0){
            System.out.println(button.get(0) + 1);
            return;
        }
        int[] slot = new int[6];
        slot[0] = 0;slot[1] = 0;slot[2] = 1;
        int minChannel = 100;
        int mindis = channel>100 ? channel-100 : 100-channel;
        if(mindis<=3){
            System.out.println(mindis);
            return;
        }
        boolean check = false;
        Arrays.fill(slot,0);
        for(int x1 = 0;x1<button.size()+1;x1++){
            for(int x2 = 0;x2<button.size()+1;x2++) {
                for (int x3 = 0;x3<button.size()+1;x3++) {
                    for (int x4 = 0;x4<button.size()+1;x4++) {
                        for (int x5 = 0;x5<button.size()+1;x5++) {
                            for (int x6 = 0;x6<button.size();x6++) {
                                slot[5] = button.get(x6);
                                int dis = 0;
                                for (int z : slot) {
                                    dis = dis == 0 ? z : dis * 10 + z;
                                }
                                int c = dis;
                                if(dis == 0){
                                    dis = channel;
                                    if (dis < mindis) {
                                        check = true;
                                        minChannel = c;
                                        mindis = dis;
                                    }
                                    continue;
                                }
                                dis = channel > dis ? channel - dis : dis - channel;
                                if (dis < mindis) {
                                    check = true;
                                    minChannel = c;
                                    mindis = dis;
                                }
                            }
                            if(x5 == button.size()) continue;
                            slot[4] = button.get(x5);
                        }
                        if(x4 == button.size()) continue;
                        slot[3] = button.get(x4);
                    }
                    if(x3 == button.size()) continue;
                    slot[2] = button.get(x3);
                }
                if(x2 == button.size()) continue;
                slot[1] = button.get(x2);
            }
            if(x1 == button.size()) continue;
            slot[0] = button.get(x1);
        }
        if(minChannel == 0){
            mindis++;
            System.out.println(mindis);
            return;
        }
        while(minChannel>0 && check == true){
            mindis++;
            minChannel = minChannel/10;
        }
        System.out.println(mindis);
    }
}
