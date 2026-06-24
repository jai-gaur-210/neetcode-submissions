class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String sor = sort(s);
            if(!map.containsKey(sor)){
                map.put(sor, new ArrayList<String>());
            }
            map.get(sor).add(s);         
        }
        for(List l : map.values()){
            ans.add(l);
        }
        return ans;
    }

    public String sort(String a){
        char [] b = a.toCharArray();
        Arrays.sort(b);
        return new String(b);
    }
}
