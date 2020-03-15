// Time Complexity : O(n) where n is the length of the ratings array * 2
// Space Complexity : O(n) where n is the length of the ratings array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 2 pass solution 

class minCandies {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        
        for (int i = 0; i < n - 1; i++) {
            int a = ratings[i];  
            int b = ratings[i + 1];
            if (b > a) {
                ans[i + 1] = ans[i] + 1;
            }
        }
        
        for (int i = n - 1; i >= 1; i--) {
            int a = ratings[i];  
            int b = ratings[i - 1];
            if (b > a) {
                ans[i - 1] = Math.max(ans[i- 1], ans[i] + 1);
            }
        }
        
        int result = 0;
        for (int i : ans) {
            result += i;
        }
        return result;
    }
}