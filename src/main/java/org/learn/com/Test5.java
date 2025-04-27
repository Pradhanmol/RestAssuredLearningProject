package org.learn.com;

import java.sql.Struct;
import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        String str = "sssellllllinnnnniiidbbsbbsbsbsbdfvqiiiiiiypmkfhhshdhfgshhs";
        String[] str2 = {"abc", "cba", "bcc", "abc", "bcc"};
        int[] arr = {5, 2, 8, 1,2, 9};
//        firstNonRepeatingChar(str);
//        DuplicateWordsInArrayString(str2);
//        findSecondSmallestInt(arr);
        String str1 = "listen";
        String str3 = "netseil";
        anagramCheck(str1,str3);
    }
    public static void firstNonRepeatingChar(String str){
        Map<Character, Integer> freqOfChar = new LinkedHashMap<>();
        for(Character ch : str.toCharArray()){
            freqOfChar.put(ch, freqOfChar.getOrDefault(ch, 0)+1);
        }
        for (Character ch : str.toCharArray()){
        }

//        for(int i = str.length()-1; i>=0; i--){
//            char lastCHar =  str.charAt(i);
//            if (freqOfChar.get(lastCHar)==1){
//                System.out.println(lastCHar);
//                break;
//            }
//        }
//        for (Character ch : str.toCharArray()){
//            if (freqOfChar.get(ch) == 1){
//                System.out.println(ch);
//                break;
//            }
//        }
    }
    //Find Duplicate Words in an Array of Strings:
    public static void  DuplicateWordsInArrayString(String[] arrStr){
      Map<String,Integer> freqOfWordInStr = new HashMap<>();
      for(String str : arrStr){
          freqOfWordInStr.put(str, freqOfWordInStr.getOrDefault(str,0)+1);
      }
      Set<String> duplicateWords = new HashSet<>();
      for(String str : arrStr){
          if (freqOfWordInStr.get(str) >1){
              duplicateWords.add(str);
          }
      }
        System.out.println(duplicateWords.toString());
    }
    //Find the Second Smallest Integer in an Array:
    //[5, 2, 8, 1, 9]
    public static void findSecondSmallestInt(int[] arr){
        Arrays.sort(arr);
        Set<Integer> uniqueEle = new LinkedHashSet<>();
        for(int ele : arr){
            uniqueEle.add(ele);
        }
        // Converting HashSet to List
        List<Integer> myList = new ArrayList<>(uniqueEle);
        System.out.println(myList.get(1));
    }

    public static void anagramCheck(String str1, String str2){
        char[] ch1Arr = str1.toCharArray();
        char[] ch2Arr = str2.toCharArray();
        Arrays.sort(ch1Arr);
        Arrays.sort(ch2Arr);
        System.out.println(Arrays.equals(ch1Arr,ch2Arr));
    }
}
