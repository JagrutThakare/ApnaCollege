package Hashing;

import java.util.*;

public class isAnagram {

    /**
     * @apiNote Time Complexity - O(N).
     * @apiNote Space Complexity - O(N).
     * @apiNote N = Length of String.
     * 
     * @param s - First String
     * @param t - Secon String
     * @return true if the Strings are anagram and false otherwise.
     */
    public static boolean Anagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        System.out.println(Anagram(s, t));
    }
}
