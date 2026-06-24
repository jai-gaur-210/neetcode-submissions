class Solution 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack<>();
        for(String ch : tokens)
        {
            if(ch.equals("+"))
            {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 + n1);
            }
            else if(ch.equals("-"))
            {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
            }
            else if(ch.equals("*"))
            {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 * n1);
            }
            else if(ch.equals("/"))
            {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            }
            else
                stack.push(Integer.valueOf(ch));
        }
        return stack.pop();
    }
}