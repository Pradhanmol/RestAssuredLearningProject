package org.learn.com;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        // occurence question play with now strings
        String str = "Hello";
        printingAllNonRepeatingChar(str);
        printingFirstNonRepeatingChar(str);
        printingMinMaxChar(str);
    }
    public static void  printingAllNonRepeatingChar(String str){
        // for finding all non repeating char in one string
        Map<Character,Integer> freqOfWordStr = new HashMap<>();
        for (char ch :str.toCharArray()){
            freqOfWordStr.put(ch, freqOfWordStr.getOrDefault(ch,0)+1);
        }
        for (char ch : str.toCharArray()){
            if(freqOfWordStr.get(ch) == 1){
                System.out.println(ch);
            }
        }
    }
    public static void  printingFirstNonRepeatingChar(String str){
        // for finding all non repeating char in one string
        Map<Character,Integer> freqOfWordStr = new HashMap<>();
        for (char ch :str.toCharArray()){
            freqOfWordStr.put(ch, freqOfWordStr.getOrDefault(ch,0)+1);
        }
        for (char ch : str.toCharArray()){
            if(freqOfWordStr.get(ch) == 1){
                System.out.println(ch);
                break;
            }
        }
    }
    public static void printingMinMaxChar(String str){
        Map<Character, Integer> freqOfCharInStr = new HashMap<>();
        for (char ch : str.toCharArray()){
            freqOfCharInStr.put(ch,freqOfCharInStr.getOrDefault(ch, 0)+1);
        }
        int minOccur = Integer.MAX_VALUE;
        int maxOccur = Integer.MIN_VALUE;
        char minChar = ' ';
        char maxChar = ' ';
        for (char ch : str.toCharArray()){
            if(freqOfCharInStr.get(ch) < minOccur){
                minOccur = freqOfCharInStr.get(ch);
                minChar = ch;
            }
        }
        for (char ch : str.toCharArray()){
            if (freqOfCharInStr.get(ch) > maxOccur){
                maxOccur = freqOfCharInStr.get(ch);
                maxChar = ch;
            }
        }
        System.out.println("Max occur "+maxChar);
        System.out.println("Min occur "+minChar);
    }

}
