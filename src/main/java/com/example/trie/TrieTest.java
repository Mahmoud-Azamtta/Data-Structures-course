package com.example.trie;

public class TrieTest {
    public static void main(String[] args) {
        MapTrie trie = new MapTrie();
        trie.insert("mahmoud");
        trie.insert("ali");
        trie.insert("intellij");
        trie.insert("alice");
        trie.insert("car");
        trie.insert("can");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("cart");


        System.out.println(trie.autoComplete(null));
    }
}
