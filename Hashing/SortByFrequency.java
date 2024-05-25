package Hashing;

// Given a string s, sort it in decreasing order based on the frequency of the characters. 
// The frequency of a character is the number of times it appears in the string.
// Return the sorted string. If there are multiple answers, return any of them.
import java.util.*;

class SortByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        TreeMap<Integer, List<Character>> r = new TreeMap<>(Collections.reverseOrder());
        StringBuilder ss = new StringBuilder();

        for (char a : s.toCharArray())
            mp.put(a, mp.getOrDefault(a, 0) + 1);

        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (!r.containsKey(entry.getValue())) {
                r.put(entry.getValue(), new ArrayList<>());
            }
            r.get(entry.getValue()).add(entry.getKey());
        }

        for (Map.Entry<Integer, List<Character>> entry : r.entrySet()) {
            int freq = entry.getKey();
            List<Character> chars = entry.getValue();
            for (char c : chars) {
                for (int i = 0; i < freq; i++) {
                    ss.append(c);
                }
            }
        }

        return ss.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("frequency"));
    }
}


