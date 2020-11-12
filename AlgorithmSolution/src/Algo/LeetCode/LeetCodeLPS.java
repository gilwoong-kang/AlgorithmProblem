package Algo.LeetCode;

public class LeetCodeLPS {
    public static void main(String[] args){
        Solution s = new Solution();

        String s0,s1,s2,s3,s4;
        s0 = "babad";
        s1 = "cbba";
        s2 = "a";
        s3 = "ac";
        System.out.println(s.longestPalindrome(s0));
        System.out.println(s.longestPalindrome(s1));
        System.out.println(s.longestPalindrome(s2));
        System.out.println(s.longestPalindrome(s3));
    }
    static class Solution {
        public String longestPalindrome(String s) {
            int range = s.length()-1;
            char[] array = s.toCharArray();
            for(int i = range;i>0;i--){
                int result = check(array,i);
                if(result > -1){
                    String r = s.substring(result,result+i+1);
                    return r;
                }
            }
            return s.substring(0,1);
        }
        public boolean windowCheck(char[] array,int startPointer, int endPointer){
            while(endPointer > startPointer){ if(array[startPointer++] != array[endPointer--]) return false; }
            return true;
        }
        public int check(char[] array,int range){
            for(int i = 0;i<(array.length-range);i++){
                boolean result = windowCheck(array,i,i+range);
                if(result) return i;
            }
            return -1;
        }
    }
}
