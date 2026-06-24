class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();
        int i=0;
        int j=str.length()-1;
        System.out.println(s);
        System.out.println(str);
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
