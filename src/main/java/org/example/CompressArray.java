package org.example;

import java.util.Arrays;

public class CompressArray {

    public static String compress(int [] array) {
        if (array == null || array.length == 0){
            return "";
        }
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        int beginNumber = array[0];
        int endNumber = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > endNumber + 1){
                if (beginNumber == endNumber){
                    sb.append(endNumber).append(",");
                    beginNumber = array[i];
                    endNumber = array[i];
                } else {
                    sb.append(beginNumber).append("-").append(endNumber).append(",");
                    beginNumber = array[i];
                    endNumber = array[i];
                }
            } else {
                endNumber = array[i];
            }
        }
        if (beginNumber == endNumber){
            sb.append(endNumber);
        } else {
            sb.append(beginNumber).append("-").append(endNumber);
        }
        return sb.toString();
    }
}