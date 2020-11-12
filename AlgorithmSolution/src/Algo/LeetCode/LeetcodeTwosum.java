package Algo.LeetCode;

import java.util.*;

public class LeetcodeTwosum {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] i = {3,3};
        int target = 6;
        int[] result = s.twoSum(i,target);
        System.out.println(result[0] + "." + result[1]);
    }
    static class Solution{
        public int[] twoSum(int[] nums,int target){
            List<Integer> array = new ArrayList<>();
            Map<Integer,Integer> originIndex = new HashMap<>();
            Map<Integer,Integer> copy = new HashMap<>();
            // 타겟수보다 높은 숫자 제거
            int count = 0;
            for (int i : nums) {
                array.add(i);
                if(!originIndex.containsKey(i)){
                    originIndex.put(i,count++);
                }else {
                    copy.put(i,count++);
                }
            }
            Collections.sort(array); // List sort
            int[] result = new int[2];

            int largePointer = array.size()-1;  // 뒤쪽 포인터
            int smallPointer = 0;     // 앞쪽 포인터
            int sum = 0;    // 덧셈 값
            while(true){
                sum = array.get(largePointer) + array.get(smallPointer);
                if(sum == target) break;    // 둘의 합이 타겟이면 브레이크
                if(sum > target){
                    largePointer--; // 타겟보다 크면 뒤쪽 포인터 앞으로
                }else if(sum < target){
                    smallPointer++; // 타겟보다 작으면 앞쪽 포인터 뒤로
                }
            }
            result[0] = originIndex.remove(array.get(smallPointer));
            if(originIndex.containsKey(array.get(largePointer))){
                result[1] = originIndex.get(array.get(largePointer));
            }
            else{
                result[1] = copy.get(array.get(largePointer));
            }
            return result;
        }
    }
}
