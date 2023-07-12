//Problem-link: https://www.codingninjas.com/studio/problems/minimum-characters-for-palindrome_8230737?challengeSlug=striver-sde-challenge&leftPanelTab=0


public class Solution {


    static boolean isPalindrome(String str, int i, int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++; j--;
        }

        return true;
    }

    public static int minCharsforPalindrome(String str) {
        //Write your code here
        int i=0, j=str.length()-1, count=0;

        while(i<j){
            if(!isPalindrome(str, i, j)){
                count++;
                j--;
            }else break;
        }

        return count;
    }

}