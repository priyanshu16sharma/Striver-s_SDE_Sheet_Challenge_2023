//Problem-link: https://www.codingninjas.com/studio/problems/compare-version-numbers_8230793?challengeSlug=striver-sde-challenge&leftPanelTab=1

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int compareVersions(String a, String b) 
    {
        // Write your code here
         long vnum1 = 0, vnum2 = 0;      
        for (int i = 0, j = 0; (i < a.length() || j < b.length());) {
            while (i < a.length()&& a.charAt(i) != '.') {
                vnum1 = vnum1 * 10 + (a.charAt(i) - '0');
                i++;
            }

            while (j < b.length() && b.charAt(j) != '.') {
                vnum2 = vnum2 * 10 + (b.charAt(j) - '0');
                j++;

            }
            if (vnum1 > vnum2)
                return 1;
            if (vnum2 > vnum1)
                return -1;
            vnum1 = vnum2 = 0;
            i++;
            j++;
        }

        return 0;
    }
}