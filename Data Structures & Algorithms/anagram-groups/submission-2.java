class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char [] b = s.toCharArray();
            Arrays.sort(b);
            String ss = new String(b);
            map.putIfAbsent(ss, new ArrayList<>());
            map.get(ss).add(s);         
        }
        return new ArrayList<>(map.values());
    }

}
