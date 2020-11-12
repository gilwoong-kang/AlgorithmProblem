package Algo.LeetCode;

import java.math.BigInteger;

public class LeetcodeAddTwoNum {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            BigInteger add = getNumber(l1).add(getNumber(l2));
            return makeNode(add);
        }

        public BigInteger getNumber(ListNode n){
            BigInteger result = BigInteger.ZERO;
            ListNode node = n;
            BigInteger pointer = BigInteger.ONE;
            while(true){
                if(node != null){
                    result = result.add(new BigInteger(String.valueOf(node.val)).multiply(pointer));
                    pointer = pointer.multiply(BigInteger.valueOf(10));
                    node = node.next;
                }else break;
            }
            return result;
        }
        public ListNode makeNode(BigInteger i){
            if(i.equals(BigInteger.ZERO)){
                return new ListNode(0);
            }
            ListNode result = new ListNode();
            ListNode pointer = result;
            while(i.compareTo(BigInteger.ZERO)>0){
                BigInteger m = i.mod(BigInteger.valueOf(10));
                i = i.divide(BigInteger.TEN);
                pointer.next = new ListNode(m.intValue());
                pointer = pointer.next;
            }
            return result.next;
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        ListNode n1,n2,n3,n4,n5,n6,n7;

//        n3 = new ListNode(9);
//        n2 = new ListNode(4,n3);
//        n1 = new ListNode(2,n2);
//
//        n7 = new ListNode(9);
//        n6 =  new ListNode(4,n7);
//        n5 = new ListNode(6,n6 );
//        n4 = new ListNode(5,n5);

        n1 = s.makeNode(new BigInteger("1000000000000000000000000000001"));
        n2 = s.makeNode(new BigInteger("465"));

        s.addTwoNumbers(n1,n2);
    }
}
