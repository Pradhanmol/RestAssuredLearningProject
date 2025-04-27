package org.learn.com;

import java.util.ArrayList;
import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int k = 31;
        String[] words = {"is", "valid", "right"};
        String variableName = "validis";
        String s = "ABCDEFFDEfghCBA";

        // Test 1: splitingIntoIncreaseSubString
        String[] result = splitingIntoIncreaseSubString(s);
        for (String str : result) {
            System.out.println(str);
        }

        // Expected Output:
        // ["ABCDEF", "F", "DE", "fgh", "C", "B", "A"]

        // Test 2: findTinyPair
        int tinyPairResult = findTinyPair(a, b, k);
        System.out.println("Tiny pair count: " + tinyPairResult);

        // Test 3: validStringNameorNot
        boolean isValid = validStringNameorNot(words, variableName.toLowerCase());
        System.out.println("Is valid variable name: " + isValid);

        // Test 4: findMaxSum
        int[] arr = {2, 1, 5, 1, 3, 2};
        int maxSumResult = findMaxSum(arr, 3);
        System.out.println("Max sum of subarray of size 3: " + maxSumResult);
    }

    public static int findTinyPair(int[] a, int[] b, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            String concatStr = String.valueOf(a[i]) + String.valueOf(b[b.length - 1 - i]);
            if (Long.parseLong(concatStr) < k) {
                count++;
            }
        }
        return count;
    }

    public static boolean validStringNameorNot(String[] words, String variableName) {
        if (words == null || words.length == 0 || variableName == null || variableName.isEmpty()) {
            return false;
        }
        int i = 0;
        while (i < variableName.length()) {
            boolean found = false;
            for (String word : words) {
                if (variableName.startsWith(word, i)) {
                    i += word.length();
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static String[] splitingIntoIncreaseSubString(String s) {
        List<String> resultList = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) + 1) {
                resultList.add(s.substring(start, i));
                start = i;
            }
        }
        resultList.add(s.substring(start));
        return resultList.toArray(new String[0]);
    }

    public static int findMaxSum(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException("Array size is smaller than k");
        }
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
