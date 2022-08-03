class Solution {
    public String numberToWords(int num) {
        int nDigits = (int)Math.floor(Math.log10(num) + 1);
        
        HashMap<Integer,String> onesMap = getOnesMap();
        HashMap<Integer,String> teensMap = getTeensMap();
        HashMap<Integer,String> tensMap = getTensMap();
        HashMap<Integer,String> placeMap = getPlaceMap();
        
        
        String numStr = "";
        
        if(num == 0) {
            return "Zero";
        }
        
        boolean isEmptyThreeDigitSet = true;
        
        for(int i = 0; i < nDigits; i++) {
            int col = nDigits - i;
            int curDigit = (int)Math.floor((num/(Math.pow(10, col-1)))%10);
            if(col % 3 == 0) {
                isEmptyThreeDigitSet = true;
            }
            if(curDigit != 0) {
                isEmptyThreeDigitSet = false;
                switch(col % 3) {
                    case 1: // 1's col
                        numStr += onesMap.get(curDigit);
                        break;
                    case 2: // 10's col
                        if(curDigit == 1) {
                            i++;
                            col = nDigits - i;
                            curDigit = (int)Math.floor((num/(Math.pow(10, col-1)))%10);
                            numStr += teensMap.get(curDigit);
                        }
                        else {
                            numStr += tensMap.get(curDigit);
                        }
                        break;
                    case 0: // 100's col
                        numStr += onesMap.get(curDigit) + "Hundred ";
                        break;
                }
            }
            if(!isEmptyThreeDigitSet) {
                numStr += placeMap.get(col);
            }
        }
        
        return numStr.trim();
    }
    
    private HashMap<Integer,String> getOnesMap() {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "One ");
        map.put(2, "Two ");
        map.put(3, "Three ");
        map.put(4, "Four ");
        map.put(5, "Five ");
        map.put(6, "Six ");
        map.put(7, "Seven ");
        map.put(8, "Eight ");
        map.put(9, "Nine ");
        return map;
    }
    
    private HashMap<Integer,String> getTeensMap() {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(0, "Ten ");
        map.put(1, "Eleven ");
        map.put(2, "Twelve ");
        map.put(3, "Thirteen ");
        map.put(4, "Fourteen ");
        map.put(5, "Fifteen ");
        map.put(6, "Sixteen ");
        map.put(7, "Seventeen ");
        map.put(8, "Eighteen ");
        map.put(9, "Nineteen ");
        return map;
    }
    
    private HashMap<Integer,String> getTensMap() {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(2, "Twenty ");
        map.put(3, "Thirty ");
        map.put(4, "Forty ");
        map.put(5, "Fifty ");
        map.put(6, "Sixty ");
        map.put(7, "Seventy ");
        map.put(8, "Eighty ");
        map.put(9, "Ninety ");
        return map;
    }
    
    private HashMap<Integer,String> getPlaceMap() {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "");
        map.put(2, "");
        map.put(3, "");
        map.put(4, "Thousand ");
        map.put(5, "");
        map.put(6, "");
        map.put(7, "Million ");
        map.put(8, "");
        map.put(9, "");
        map.put(10, "Billion ");
        map.put(11, "");
        map.put(12, "");
        map.put(13, "Trillion");
        map.put(14, "");
        map.put(15, "");
        return map;
    }
}