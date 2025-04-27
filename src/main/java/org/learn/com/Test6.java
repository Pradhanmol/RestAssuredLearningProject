package org.learn.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test6 {
    public static void main(String[] args) {
//        int[] arr = {5,2,3,7};
//        // second largest
////        Arrays.sort(arr);
//        for(int i = 0; i<arr.length-1; i++){
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[i]>arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(arr[arr.length-2]);

        String str = "hi how are you";
        // o/p  h --> 2
        Map<Character,Integer> freqOfChar  = new HashMap<>();
        for (char ch : str.toCharArray()){
           if (ch != ' '){
               freqOfChar.put(ch,freqOfChar.getOrDefault(ch,0)+1);
           }
        }
        System.out.println(freqOfChar);
    }
}
