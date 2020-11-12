package Algo.LeetCode;

public class LeetCodeLSC {
    public static void main(String[] args){
        Solution s = new Solution();
        String t1,t2,t3,t4,t5;
        t1 = "abcdefcd";
        t2 = "abcabcb";
        t3 = "bbbbb";
        t4 = "qwwkew";
        t5 = "abba";
//        System.out.println(s.lengthOfLongestSubstring(t1));
//        System.out.println(s.lengthOfLongestSubstring(t2));
//        System.out.println(s.lengthOfLongestSubstring(t3));
//        System.out.println(s.lengthOfLongestSubstring(t4));
        System.out.println(s.lengthOfLongestSubstring(t5));

    }
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.equals("")) return 0;
            char[] string = s.toCharArray();
            int startPointer = 0;
            int endPointer = 0;
            int maxlength = 1;
            bigLoop:
            while(endPointer < string.length-1){
                if(startPointer == endPointer){ //  포인터가 같을 경우
                    if(string[endPointer+1] == string[startPointer]){   // 포인터 다음 위치 값이 현재 값과 같을 경우
                        startPointer++; endPointer++;   // 다음 위치를 검사한다
                    }
                    else{   // 값이 다르다면 윈도우 길이를 늘린다.
                        if(maxlength < 2) maxlength = 2;
                        endPointer++;
                    }
                }
                // 중복값 체크
                if((endPointer + 1 ) > string.length-1) break;
                char c = string[endPointer+1];
                for(int i = startPointer; i<=endPointer;i++){
                    if(string[i] == c){ //   중복 값이라면
                        startPointer = i+1;
                        endPointer++;
                        continue bigLoop;
                    }
                }
                // 중복이 없는 값이라면
                endPointer++;
                maxlength = maxlength < (endPointer - startPointer +1) ? (endPointer - startPointer + 1) : maxlength;
            }
            return maxlength;
        }
    }
}
