class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if(stack.empty()) return false;
                char c2 = stack.pop();
                if(c == ')' && c2 == '(') continue;
                if(c == ']' && c2 == '[') continue;
                if(c == '}' && c2 == '{') continue;
                return false;
            }
        }
        if(!stack.empty()) return false;
        return true;
    }
}