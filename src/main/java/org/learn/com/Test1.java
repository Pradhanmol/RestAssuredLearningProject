package org.learn.com;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
//        int[] arr = {3,5,5,5,6,1,1};
        // 1. mapping element with there freq
        // 2. then check which ever element freq ===1
        // 3. print that whoever fall into thi freq ===1
//        printingNonRepeatEle(arr);
//        printingFirstNonRepeatEle(arr);
//        printingMinMaxFreqElementInArray(arr);
//        String str = "aaaabbbbeee";
//        printOccurenecOfCharInStr(str);
        int[] arr = {1,2,4,5,6};
        findTheMissingNum(arr);
    }
    public static void  printingNonRepeatEle(int[] arr) {
        Map<Integer, Integer> freqOfElement = new HashMap<>();
        for (int num : arr) {
            freqOfElement.put(num, freqOfElement.getOrDefault(num, 0) + 1);
        }
        for (int num : arr){
            if(freqOfElement.get(num) ==1){
                System.out.println("printingNonRepeatEle "+num);
            }
        }
    }
    public static void  printingFirstNonRepeatEle(int[] arr) {
        Map<Integer, Integer> freqOfElement = new HashMap<>();
        for (int num : arr) {
            freqOfElement.put(num, freqOfElement.getOrDefault(num, 0) + 1);
        }
        for (int num : arr){
            if(freqOfElement.get(num) == 1){
                System.out.println("printingFirstNonRepeatEle "+num);
                break;
            }
        }
    }
    public static void printingMinMaxFreqElementInArray(int[] array){
        // first we have to define the map for counting the freq of element
        Map<Integer,Integer> freqOfElem = new HashMap<>();
        for (int num : array){
            freqOfElem.put(num, freqOfElem.getOrDefault(num,0)+1);
        }
        // Then we have to find the min & max freq from the element
        // for that we need to create two variable first which maintain the freq of elem in array
        // & then iterate over the map & set the min max freq on the basis of check using if loop that w
        // we are setting using two different loop
        int maxOccur = Integer.MIN_VALUE;
        int minOccur = Integer.MAX_VALUE;
        int minEle = -1;
        int maxELem = -1;
        // for finding min occur elem in array
        for (int num : array){
            if (freqOfElem.get(num)<minOccur) {
                minOccur = freqOfElem.get(num);
                minEle = num;
            }
        }
        // for finding max occur elem in array
        for (int num : array){
            if (freqOfElem.get(num) > maxOccur){
                maxOccur = freqOfElem.get(num);
                maxELem = num;
            }
        }
        System.out.println("Max ele :"+ maxELem+"-->"+"max occur :" +maxOccur);
        System.out.println("Min ele :"+ minEle+"-->"+"min occur :" +minOccur);
        System.out.println("maxFreqofElem" + maxELem);
        System.out.println("minFreOfElem" + minEle);
    }
    public static void strRevWordOnly(String str){
        String[] words = str.split(" ");
        StringBuilder reverseStr = new StringBuilder();
        for (String word : words){
            reverseStr.append(new StringBuilder(word).reverse()).append(" ");
        }
        System.out.println(reverseStr.toString());
    }
    public static void strRev(String str){
        String[] words = str.split(" ");
        StringBuilder reverseStr = new StringBuilder(str);
        reverseStr.reverse();
        System.out.println(reverseStr.toString());
    }
    public static void printOccurenecOfCharInStr(String str){
        Map<Character, Integer> freqCountOfChar = new HashMap<>();
        for (char ch : str.toCharArray()){
            freqCountOfChar.put(ch, freqCountOfChar.getOrDefault(ch,0)+1);
        }
        for (Map.Entry<Character, Integer> entry : freqCountOfChar.entrySet()){
            System.out.print(entry.getKey()+""+entry.getValue());
        }
    }
    public static void findTheMissingNum(int[] arr){
        int n = arr.length+1;
        int totalSum = n * (n+1)/2;
        int arrSum = 0;
        for (int num : arr){
            arrSum += num;
        }
        int missingNum = totalSum-arrSum;
        System.out.println("Missing Number is : " + missingNum);
    }
}
