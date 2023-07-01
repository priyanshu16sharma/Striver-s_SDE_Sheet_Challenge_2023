


import java.util.* ;
import java.io.*; 
public class Solution {
    public static int atoi(String str) {
        // Write your code here.
        int num = 0;
        int neg = str.charAt(0)=='-'? 1:0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)>=48 &&str.charAt(i)<=57){
                num*=10;
                num+= (int)str.charAt(i)-48;
            }
        }
        num = neg==1?0-num: num;

        return num;
    }
}
