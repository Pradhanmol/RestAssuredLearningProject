package org.learn.com;

public class Test3 {
    public static void main(String[] args) {
        String str = "abccbc";
        allSubStringReturnWithPalindrome(str);
    }
    public static void revEachWordStr(String str){
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words ){
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        System.out.println(result);
    }
    public static void revFullStr(String str){
//        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder(str);
        result.reverse();
        System.out.println(result);
    }
    public static void revStrNotWrd(String str){
        String[] words = str.split(" ");
        StringBuilder revStr = new StringBuilder();
        for (String word : words){
            revStr.append(new StringBuilder(word)).reverse().append(" ");
        }
        System.out.println(revStr);
    }
    public static void allSubStringReturnWithPalindrome(String str){
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (isPalindrome(str.substring(i,j))){
                    System.out.println(str.substring(i,j));
                }
            }
        }
    }
    public static Boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        while (i<=j){
            if (str.charAt(i)!=str.charAt(j)){
                return  false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
