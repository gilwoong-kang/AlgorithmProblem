package Algo.etc;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode rootNode;
    Trie() {
        rootNode = new TrieNode();
    }
    void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }
    // 특정 단어가 들어있는지 확인
    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);
            if (node == null)
                return false;
            thisNode = node;
        }
        return thisNode.isLastChar();
    }
    // 특정 단어 지우기
    void delete(String word) {
        delete(this.rootNode, word, 0); // 최초로 delete 던지는 부분
    }

    private void delete(TrieNode thisNode, String word, int index) {
        char character = word.charAt(index);
        if(!thisNode.getChildNodes().containsKey(character))
            throw new Error("There is no [" + word + "] in this Trie.");
        TrieNode childNode = thisNode.getChildNodes().get(character);
        index++;
        if(index == word.length()) {
            if (!childNode.isLastChar())
                throw new Error("There is no [" + word + "] in this Trie.");
            childNode.setIsLastChar(false);
            if (childNode.getChildNodes().isEmpty())
                thisNode.getChildNodes().remove(character);
        }else {
            delete(childNode, word, index); // 콜백함수부분
            if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
                thisNode.getChildNodes().remove(character);
        }
    }
    public class TrieNode {
        // [ 변수 ]
// 자식 노드 맵
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        // 마지막 글자인지 여부
        private boolean isLastChar;
        // [ GETTER / SETTER 메서드 ]
// 자식 노드 맵 Getter
        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
        // 마지막 글자인지 여부 Getter
        boolean isLastChar() {
            return this.isLastChar;
        }
        // 마지막 글자인지 여부 Setter
        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }
}
