class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int l = 0;
        int maxF = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {

            count[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxF > k) {
                count[s.charAt(l) - 'A']--;
                l++;

                maxF = Math.max(maxF, count[s.charAt(l) - 'A']); 
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}