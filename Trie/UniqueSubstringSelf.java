package Trie;
/* Count Unique Substring
 * Given a string of length n of lowercase alphabet char, 
 * we need to count total number of distinct substrings of
 * this string
 * 
 * count unique substring  = all unique prefix of all suffix of string
 */

public class UniqueSubstringSelf {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static int count = 1;

    public static void insert(String word) { // O(L)
        Node curr = root;
        int idx;
        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
                count++;
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static Boolean Search(String word) { // O(L)
        Node curr = root;
        int idx;
        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void main(String[] args) {
        String str = "ababa"; // ans = 10

        // suffix -> insert in trie
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(count);
    }
}
