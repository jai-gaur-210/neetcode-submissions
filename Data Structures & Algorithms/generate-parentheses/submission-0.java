class Solution {
    public void help(List<String> lst, int l, int r, int n, String s){
        if(s.length() == 2*n){
            lst.add(s);
            return;
        }
        if(l < n){
            help(lst, l+1, r, n, s+"(");
        }
        if(r < l){
            help(lst, l, r+1, n, s+")");
        }
    }

    public List<String> generateParenthesis(int n) {
        String ans = "";
        List<String> list = new ArrayList<>();
        help(list, 0, 0, n, ans);
        return list;
    }
}
