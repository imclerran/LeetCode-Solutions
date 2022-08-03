class Solution {
    public int myAtoi(String s) {
        int result = 0;
        ArrayList<Character> charDigits = new ArrayList<Character>();
        int signMultiplier = 1;
        
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        if(i >= s.length()) return 0;
        
        if('-' == s.charAt(i)) {
            signMultiplier = -1;
            i++;
        }
        else if('+' == s.charAt(i)) i++;        
        
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            charDigits.add(s.charAt(i));
            i++;
        }
        for(int j = 0; j < charDigits.size(); j++) {
            int index = charDigits.size() - j - 1;
            int adder = (int)(signMultiplier * (char2i(charDigits.get(index)) * Math.pow(10,j)));
            if(signMultiplier == 1 && (Integer.MAX_VALUE - result < adder || adder < 0)) {
                return Integer.MAX_VALUE;
            }
            else if(signMultiplier == -1 && (Integer.MIN_VALUE - result > adder || adder > 0)) {
                return Integer.MIN_VALUE;
            }
            result += adder;
        }
        return result;
    }
    
    private int char2i(char c) {
        // ASCII codes for '0' to '9' are 48-57
        return ((int)c) - 48;
    }
}