package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Conf> dump = new ArrayList<>();
        for(int i =0;i<n;i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            dump.add(new Conf(s,e));
        }
        Collections.sort(dump);
        int pointer = dump.get(0).endTime;
        int result = 1;
        for(int i = 1;i<dump.size();i++){
            Conf c = dump.get(i);
            if(pointer <= c.startTime){
                pointer = c.endTime;
                result++;
            }
        }
        System.out.println(result);
    }

    public static class Conf implements Comparable<Conf>{
        int startTime;
        int endTime;

        public Conf(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Conf o) {
            if(this.endTime == o.endTime){
                return this.startTime < o.startTime ? -1 : 1;
            }else{
                return this.endTime < o.endTime ? -1 : 1;
            }
        }
    }
}
