package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Substrings {

    public static int findUniqueSubstring(String s, Integer slidingWindowSize) {
        Map<Character, Integer> map = new HashMap<>();
        Integer substringCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
            if (i > (slidingWindowSize-1)){
                int j = i - slidingWindowSize;
                if (map.get(s.charAt(j)) > 1) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                } else {
                    map.remove(s.charAt(j));
                }
            }
            if (slidingWindowSize.equals(map.size())){
                substringCount++;
            }
        }
        return substringCount;
    }
}
