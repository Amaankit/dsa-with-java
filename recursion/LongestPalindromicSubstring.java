package recursion;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        // Try out the function with a test word
        String s = "babad";
        // Print the answer: how long is the longest part of the word with no repeating letters?
        System.out.println(longestPalindrome(s)); // Output will be 3 for "abc"
    }

    private static int solve(String s,int i,int j){
        if(i>=j){
            return 1;
        }
        else if(s.charAt(i)==s.charAt(j)){
            return solve(s,i+1,j-1);
        }
        return 0;
    }

    public static String longestPalindrome(String s) {
        int startingIndex=-1;
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(solve(s,i,j)==1){
                    if(j-i+1>maxLength){
                        maxLength=j-i+1;
                        startingIndex=i;
                    }
                }
            }
        }
        return s.substring(startingIndex,startingIndex+maxLength);
    }
}
