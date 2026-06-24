class Solution {
    public int characterReplacement(String s, int k) {
        int []freq = new int[26];
        int l=0; 
        int mFreq = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'A']++;
            mFreq = Math.max(mFreq, freq[s.charAt(i) - 'A']);
            while(((i-l+1)- mFreq) > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(res, i-l+1); 
        }
        return res;
    }
}
