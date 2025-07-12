import java.util.HashMap;

public class Practice {public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int n = 3;
    System.out.println(getMaxSum(arr, n));
}


public static  int getMaxSum(int[] arr,int n){
    int lIndex= 0;
    int rIndex = 0;
    int maxSum = 0;
    int leftSum = 0;
    int rightSum = 0;

    while (rIndex<arr.length){

        rIndex++;
    }
    return maxSum;

}
    // This function finds the longest stretch in a word where no letter repeats
    public static int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    int l=0;
    int r=0;
    int n = s.length();
    HashMap<Character,Integer> map = new HashMap<>();
    while(r<n){
        char c = s.charAt(r);
        Integer charIndex = map.get(c);
        if(charIndex!=null && charIndex>l){
            l=charIndex + 1;
        }
        int length = r-l+1;
        maxLength = Math.max(maxLength,length);
        map.put(c,r);
        r++;

    }


    return maxLength;


    }
}
