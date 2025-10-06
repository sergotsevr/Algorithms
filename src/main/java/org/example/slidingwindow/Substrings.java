package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Substrings {

    public static int findUniqueSubstring(String s, Integer slidingWindowSize) {
        Map<Character, Integer> map = new HashMap<>();
        int substringCount = 0;
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

    public static int longestWindowWithUniqueSubstrings(String s) {
        Integer maxSize = 0;
        int counter = 0;
        while (maxSize.equals(0)){
           if (findUniqueSubstring(s, (s.length()-counter)) > 0){
               maxSize = s.length()-counter;
           }
            counter++;
        }
        return maxSize;
    }
}
