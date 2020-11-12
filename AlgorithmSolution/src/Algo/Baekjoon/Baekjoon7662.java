package Algo.Baekjoon;

import java.util.*;

public class Baekjoon7662 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int k = sc.nextInt();
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new ComparatorDescending());
            PriorityQueue<Pair> minHeap = new PriorityQueue<>(new ComparatorAscending());
            boolean[] visited = new boolean[k];
            sc.nextLine();
            for (int i = 0; i < k; i++) {
                String[] input = sc.nextLine().split(" ");
                String op = input[0];
                long n = Long.parseLong(input[1]);

                if (op.equals("I")) {
                    Pair p = new Pair(i, n);
                    minHeap.add(p);
                    maxHeap.add(p);
                } else {
                    if (n == 1) {
                        if (!maxHeap.isEmpty()) {
                            Pair p = maxHeap.peek();
                            if (!visited[p.idx]) {
                                maxHeap.poll();
                                visited[p.idx] = true;
                            }
                        }
                    } else {
                        if (!minHeap.isEmpty()) {
                            Pair p = minHeap.peek();
                            if (!visited[p.idx]) {
                                minHeap.poll();
                                visited[p.idx] = true;
                            }

                        }
                    }
                }

                while(!minHeap.isEmpty()) {
                    if (!visited[minHeap.peek().idx]) {
                        break;
                    } else {
                        minHeap.poll();
                    }
                }

                while(!maxHeap.isEmpty()) {
                    if (!visited[maxHeap.peek().idx]) {
                        break;
                    } else {
                        maxHeap.poll();
                    }
                }
            }
            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek().value + " " + minHeap.peek().value + "\n");
            }

        }
        System.out.println(sb.toString());
    }

    static class Pair {
        int idx;
        long value;

        Pair(int idx, long value) {
            this.idx = idx;
            this.value = value;
        }
    }

    static class ComparatorDescending implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            // TODO Auto-generated method stub
            if (p1.value < p2.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static class ComparatorAscending implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            // TODO Auto-generated method stub
            if (p1.value < p2.value) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
