// Time Complexity : O(n) where n is the length of the tasks array
// Space Complexity : O(1) since count array has a fixed length of 26
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int maxFreq = count[count.length - 1];
        int maxFreqCount = 0;
        for (int i : count) {
            if (i == maxFreq) {
                maxFreqCount++;
            }
        }
        int partitions = maxFreq - 1;
        int empty = (n - maxFreqCount + 1) * partitions;
        int pending = tasks.length - maxFreq * maxFreqCount;
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
    }
}