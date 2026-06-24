class Solution {

    List<Integer> l = new ArrayList<>();
    public String encode(List<String> strs) {
        String ans = "";
        if(strs == null){
            return ans;
        }
        for(int i=0; i<strs.size(); i++){
            l.add(strs.get(i).length());
            ans += strs.get(i);
        }
        return ans;
    }

    public List<String> decode(String str) {
        //neetcodeloveyou
        if(str == null || str == ""){
            return new ArrayList<String>();
        }
        List<String> ans = new ArrayList<>();
        int k = 0;
        int a = l.get(k);
        char [] chr = str.toCharArray();
        String st = "";
        for(int i=0; i<chr.length; i++){      
            if(i == a){
                ans.add(st);
                st = "";
                k++;
                a += l.get(k);
            }
            st += chr[i];
        }
        ans.add(st);
        return ans;
    }
}
