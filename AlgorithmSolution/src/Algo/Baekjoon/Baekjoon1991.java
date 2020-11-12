package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1991 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String,Node> nodes = new HashMap<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i<n;i++){
            String[] s = scanner.nextLine().split(" ");
            Node root,left,right;
            // root 넣기
            if(!nodes.containsKey(s[0])){
                root = new Node(s[0]);
                nodes.put(s[0],root);
            } else root = nodes.get(s[0]);
            // left 넣기
            if(!s[1].equals("."))if(!nodes.containsKey(s[1])){
                left = new Node(s[1]);
                nodes.put(s[1],left);
            } else left = nodes.get(s[1]); else left = null;
            // right 넣기
            if(!s[2].equals("."))if(!nodes.containsKey(s[2])){
                right = new Node(s[2]);
                nodes.put(s[2],right);
            } else right = nodes.get(s[2]); else right = null;

            // Tree input
            if(left != null){ root.left = left; }
            if(right != null){ root.right = right; }
        }
        System.out.println(front(nodes.get("A"),new StringBuilder()).toString());
        System.out.println(middle(nodes.get("A"),new StringBuilder()).toString());
        System.out.println(back(nodes.get("A"),new StringBuilder()).toString());
    }

    private static StringBuilder front(Node root,StringBuilder result){
        result.append(root.nodeName);
        if(root.left != null)front(root.left,result);
        if(root.right != null)front(root.right,result);
        return result;
    }

    private static StringBuilder middle(Node root,StringBuilder result){
        if(root.left != null) middle(root.left,result);
        result.append(root.nodeName);
        if(root.right != null) middle(root.right,result);
        return result;
    }

    private static  StringBuilder back(Node root,StringBuilder result){
        if(root.left != null) back(root.left,result);
        if(root.right != null) back(root.right,result);
        result.append(root.nodeName);
        return result;
    }
    private static class Node{
        String nodeName;
        Node left;
        Node right;

        public Node(String nodeName) {
            this.nodeName = nodeName;
        }

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        public Node(String nodeName, Node left, Node right) {
            this.nodeName = nodeName;
            this.left = left;
            this.right = right;
        }
    }
}
