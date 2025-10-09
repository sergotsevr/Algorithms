package org.example;

import java.util.HashMap;
import java.util.Map;

public class ZigZagPatternString {


    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();

        int prevPeak = 0;
        int nextPeak = 0;
        int currChar = 0;
        int minusCoef = 0;
        int currNumber = 0;
        while (currChar < s.length()) {
            nextPeak = prevPeak + (2 * numRows - 2);
            while (currChar < nextPeak && currChar < s.length()) {

                if (map.containsKey(currNumber)) {
                    map.get(currNumber).append(s.charAt(currChar));
                } else {
                    map.put(currNumber, new StringBuilder());
                    map.get(currNumber).append(s.charAt(currChar));
                }
                if (currChar < nextPeak-numRows+1) {
                    currNumber ++;
                } else {
                    currNumber --;
                }
                currChar++;
            }
            minusCoef = prevPeak + (2 * numRows - 2);
            prevPeak = nextPeak;
        }
        for (Map.Entry<Integer, StringBuilder> entry : map.entrySet()) {
            sb.append(entry.getValue().toString());
        }
        return sb.toString();
    }
}