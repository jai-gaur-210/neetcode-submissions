class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for(String s : strs){
            str += s;
            str += ";";
        }
        System.out.println(str);
        return str;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if(str == ""){
            return ans;
        }
        String s = "";
        for(char c : str.toCharArray()){
            if( c == ';'){
                ans.add(s);
                s = "";
            }
            else{
                s+= c;
            }
        }
        return ans;
    }
}
