//problem-link: https://www.codingninjas.com/codestudio/challenges/striver-sde-challenge?activeProblems=true


public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		StringBuilder ans = new StringBuilder("");
		int spccnt=1;
		int offset=0;
		for(int i=str.length()-1; i>=0; i--){
			if(spccnt<1 || str.charAt(i)!=' '){
				if(str.charAt(i)==' '){
					spccnt++;
					offset=ans.length();
					ans.insert(offset, str.charAt(i));
					offset++;
					continue;
				}
				ans.insert(offset, str.charAt(i));
				spccnt=0;
				
			}
		}

		return ans.toString();
	}
}
