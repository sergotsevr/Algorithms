package org.example;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currLength = 0;
        Set<Character> dict = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (dict.contains(s.charAt(i))){
                if (currLength>maxLength){
                    maxLength = currLength;
                    dict.clear();
                    dict.add(s.charAt(i));
                    currLength = 1;
                } else {
                    dict.clear();
                    dict.add(s.charAt(i));
                    currLength = 1;
                }
            }
            else {
                dict.add(s.charAt(i));
                currLength++;
            }
        }
        if (currLength>maxLength){
            maxLength = currLength;
        }
        return maxLength;
    }
}
