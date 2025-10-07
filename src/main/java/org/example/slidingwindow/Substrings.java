package org.example.slidingwindow;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
            if (i > (slidingWindowSize - 1)) {
                int j = i - slidingWindowSize;
                if (map.get(s.charAt(j)) > 1) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                } else {
                    map.remove(s.charAt(j));
                }
            }
            if (slidingWindowSize.equals(map.size())) {
                substringCount++;
            }
        }
        return substringCount;
    }

    public static int longestWindowWithUniqueSubstrings(String s) {
        Integer maxSize = 0;
        int counter = 0;
        while (maxSize.equals(0)) {
            if (findUniqueSubstring(s, (s.length() - counter)) > 0) {
                maxSize = s.length() - counter;
            }
            counter++;
        }
        return maxSize;
    }


    public static int longestWindowWithUniqueSubstringsAlt(String s) {
        Set<Character> currWindow = new HashSet<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int maxWindowSize = 0;
        while (rightPointer < s.length()) {
            if (!currWindow.contains(s.charAt(rightPointer))) {
                currWindow.add(s.charAt(rightPointer));
                maxWindowSize = Math.max(maxWindowSize, rightPointer - leftPointer + 1);
                rightPointer++;
            } else {
                currWindow.remove(s.charAt(leftPointer));
                leftPointer++;
            }
        }
        return maxWindowSize;
    }

    public static int longestWindowWithUniqueSubstringsMaxTwoCharAlt(String s) {
        Map<Character, Integer> currWindow = new HashMap<>();
        int leftPointer = 0;
        int maxWindowSize = 0;
        for (int rp = 0; rp < s.length(); rp++) {
            if (currWindow.containsKey(s.charAt(rp))) {
                currWindow.put(s.charAt(rp), currWindow.get(s.charAt(rp)) + 1);
                maxWindowSize = Math.max(maxWindowSize, rp - leftPointer + 1);
            } else {

                currWindow.put(s.charAt(rp), 1);
                while (currWindow.size() > 2) {
                    if (currWindow.get(s.charAt(leftPointer)) > 1) {
                        currWindow.put(s.charAt(leftPointer), currWindow.get(s.charAt(leftPointer)) - 1);
                        leftPointer++;
                    } else {
                        currWindow.remove(s.charAt(leftPointer));
                        leftPointer++;
                    }
                }
                maxWindowSize = Math.max(maxWindowSize, rp - leftPointer + 1);
            }
        }
        return maxWindowSize;
    }

    public static int longestWindowWithUniqueSubstringsMaxKCharAlt(String s, int k) {
        Map<Character, Integer> currWindow = new HashMap<>();
        int leftPointer = 0;
        int maxWindowSize = 0;
        for (int rp = 0; rp < s.length(); rp++) {
            if (currWindow.containsKey(s.charAt(rp))) {
                currWindow.put(s.charAt(rp), currWindow.get(s.charAt(rp)) + 1);
                maxWindowSize = Math.max(maxWindowSize, rp - leftPointer + 1);
            } else {

                currWindow.put(s.charAt(rp), 1);
                while (currWindow.size() > k) {
                    if (currWindow.get(s.charAt(leftPointer)) > 1) {
                        currWindow.put(s.charAt(leftPointer), currWindow.get(s.charAt(leftPointer)) - 1);
                        leftPointer++;
                    } else {
                        currWindow.remove(s.charAt(leftPointer));
                        leftPointer++;
                    }
                }
                maxWindowSize = Math.max(maxWindowSize, rp - leftPointer + 1);
            }
        }
        return maxWindowSize;
    }


    public static String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        int curSize = 0;
        Pair<Integer, Integer> res = new Pair<>(0, Integer.MAX_VALUE);
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), 1);
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
        }

        int lp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    curSize++;
                }
            }
            while (curSize == map.size()) {
                int windowCurSize = i - lp;
                int prevSize = res.getSecond() - res.getFirst();
                if (windowCurSize < prevSize) {
                    res.setFirst(lp);
                    res.setSecond(i);
                }
                if (map.containsKey(s.charAt(lp))) {
                    if (map.get(s.charAt(lp)) == 0) {
                        curSize--;
                    }
                    map.put(s.charAt(lp), map.get(s.charAt(lp)) + 1);

                }
                lp++;
            }

        }
        return s.substring(res.getFirst(), res.getSecond() + 1);
    }

    @Setter
    @Getter
    static class Pair<K, V> {
        private K first;
        private V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }


    @Setter
    @Getter
    static class IntPair extends Pair<Integer, Integer> {


        public IntPair(Integer first, Integer second) {
            super(first, second);
        }
        public Integer getSize(){
            return getSecond() - getFirst();
        }
    }


    public static String longestPalindrome(String s) {


        IntPair res = new IntPair(0, 0);
        for (int lp = 0; lp < s.length(); lp++) {
            for (int rp = lp; rp < s.length(); rp++) {
                if (s.substring(lp,rp+1).contentEquals(new StringBuilder(s.substring(lp,rp+1)).reverse())
                        && res.getSize() < rp - lp){
                    res.setFirst(lp);
                    res.setSecond(rp);
                }
            }
        }
        return s.substring(res.getFirst(), res.getSecond() + 1);
    }

    public static String longestPalindromeManaker(String s) {
        if (s == null || s.isEmpty()) return "";

        // Преобразуем строку для обработки четных и нечетных палиндромов
        String T = preprocess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i;

            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Пытаемся расширить палиндром
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // Если палиндром расширился за R, обновляем центр и радиус
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // Находим максимальный палиндром
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
}
