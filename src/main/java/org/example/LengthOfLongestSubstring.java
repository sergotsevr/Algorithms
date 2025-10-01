package org.example;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    //Рабочий вариант, но неоптимальный
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currLength = 0;
        Set<Character> dict = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            currLength = 0;
            for (int j = i; j < s.length(); j++) {
                if (dict.contains(s.charAt(j))) {
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        dict.clear();
                        dict.add(s.charAt(j));
                        currLength = 1;
                    } else {
                        dict.clear();
                        dict.add(s.charAt(j));
                        currLength = 1;
                    }
                } else {
                    dict.add(s.charAt(j));
                    currLength++;
                }
            }
            if (currLength > maxLength) {
                maxLength = currLength;
            }
            dict.clear();
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringSlidingWindow(String s) {
        if (s == null || s.length() == 0) return 0;

        int maxLength = 0;
        Set<Character> window = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            Character current = s.charAt(right);

            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstringV3(String s) {

        int start=0;
        int maxlength=0;
        int lastseen[]=new int[128];

        for (int i=0;i<s.length();i++){
            char chr=s.charAt(i);
            if(lastseen[chr]>start){
                start=lastseen[chr];
            }
            lastseen[chr]=i+1;
            maxlength=Math.max(maxlength,i+1-start);
        }
        return maxlength;
    }
}
