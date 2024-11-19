package org.example.tree.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 1268. 搜索推荐系统
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，
 * 推荐 products 数组中前缀与 searchWord 相同的最多三个产品。
 * 如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 * 示例 1：
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 * 示例 2：
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * 示例 3：
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * 示例 4：
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 * 链接：https://leetcode.cn/problems/search-suggestions-system/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/18 23:08
 */
public class SearchSuggestionsSystem {

    private class TrieNode {
        // 子节点
        TrieNode[] children;
        // 建议产品列表
        List<String> suggestions;

        public TrieNode() {
            this.children = new TrieNode[26];
            suggestions = new ArrayList<>();
        }
    }

    private class Trie {

        TrieNode root = new TrieNode();

        public void insert(String product) {
            TrieNode node = root;
            for (char c : product.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                if (node.suggestions.size() < 3) {
                    node.suggestions.add(product);
                }
            }
            printTrie();
        }

        /**
         * 打印前缀树结构，显示清晰的层级关系。
         */
        public void printTrie() {
            printNode(root, "", 0);
        }

        /**
         * 打印前缀树的辅助递归方法。
         *
         * @param node   当前节点
         * @param prefix 当前路径的前缀
         * @param level  当前层级
         */
        private void printNode(TrieNode node, String prefix, int level) {
            if (node == null) return;

            // 使用自定义方法生成缩进
            String indentation = space(level);
            System.out.println(indentation + prefix + " -> " + node.suggestions);

            // 递归打印所有子节点
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    char childChar = (char) ('a' + i); // 子节点对应的字符
                    printNode(node.children[i], prefix + childChar, level + 1);
                }
            }
        }

        /**
         * 根据层级生成缩进字符串。
         *
         * @param level 层级
         * @return 对应层级的缩进字符串
         */
        private String space(int level) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("  "); // 每层两个空格
            }
            return sb.toString();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 构建字典树
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        TrieNode node = trie.root;
        List<List<String>> result = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children[c - 'a'];
            }
            if (node == null) {
                result.add(new ArrayList<>());
            } else {
                result.add(node.suggestions);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        SearchSuggestionsSystem system = new SearchSuggestionsSystem();

        // 示例测试用例1
        String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";
        System.out.println(system.suggestedProducts(products1, searchWord1));

        // 示例测试用例2
        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        System.out.println(system.suggestedProducts(products2, searchWord2));

        // 示例测试用例3
        String[] products3 = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord3 = "bags";
        System.out.println(system.suggestedProducts(products3, searchWord3));

        // 示例测试用例4
        String[] products4 = {"havana"};
        String searchWord4 = "tatiana";
        System.out.println(system.suggestedProducts(products4, searchWord4));
    }

}
