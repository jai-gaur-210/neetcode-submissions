class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.add(c);
            }
            else{
                if(st.isEmpty()) return false;
                char temp = st.pop();
                if(c == ')' && temp == '('){
                    continue;
                }
                else if(c == '}' && temp == '{'){
                    continue;
                }
                else if(c == ']' && temp == '['){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
