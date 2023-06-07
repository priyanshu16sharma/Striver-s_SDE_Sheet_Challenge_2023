//problem: https://www.codingninjas.com/codestudio/problems/modular-exponentiation_8230803?challengeSlug=striver-sde-challenge

import java.io.*;
import java.util.* ;

public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here. 
        long pow=x;
        long ans = 1;

        while(n>0){
            if(n%2==1){
                ans = (ans*pow)%m;
            }
            pow = ((pow%m)*(pow%m))%m;
            n = n/2;
        }       

        return (int) ans;
    }
}