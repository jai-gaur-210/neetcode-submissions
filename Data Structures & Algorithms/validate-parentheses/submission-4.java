class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // (])
        for(int i=0; i<s.length(); i++){
            Character a = s.charAt(i);
            if(a == '(' || a == '{' || a == '['){
                stack.push(a);
            }
            else if(!stack.isEmpty() && a == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }
                else{
                    break;
                }
            }
            else if(!stack.isEmpty() && a == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                }
                else{
                    break;
                }
            }
            else if(!stack.isEmpty() && a == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                }
                else{
                    break;
                }
            }
            else{
                return false;
            }
        }

        if(stack.isEmpty()) return true;

        return false;
    }
}
