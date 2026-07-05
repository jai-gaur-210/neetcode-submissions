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
                if(
                    (c == ')' && temp != '(') ||
                    (c == '}' && temp != '{') ||
                    (c == ']' && temp != '[')
                )return false;
            }
        }
        return st.isEmpty();
    }
}
