const ONE: char = 'I';
const FIVE: char = 'V';
const TEN: char = 'X';
const FIFTY: char = 'L';
const HUNDRED: char = 'C';
const FIVE_HUNDRED: char = 'D';
const THOUSAND: char = 'M';

impl Solution {    
    pub fn int_to_roman(num: i32) -> String {
        /*
            loop ->
            mod by 10 to get right-most digit and store in var
            convert current digit to roman
            add roman digit conversion to roman string
            subtract current digit, then divid by 10 to shift left
            finish loop when subtracting current digit reduces number to zero
        */
        let mut loopNum = num;
        let mut exp: i16 = 0;
        let mut roman = String::from("");
        
        while loopNum > 0 {
            let digit = loopNum % 10;
            loopNum = (loopNum - digit) / 10;
            let mut curRoman = Solution::i2r(digit, exp);
            curRoman.push_str(&roman);
            roman = curRoman;
            exp = exp + 1;
        }
        return roman;
    }
    
    pub fn i2r(digit: i32, exponent: i16) -> String {
        let mut roman = String::from("");
        let mut ones: char = ONE;
        let mut fives: char = FIVE;
        let mut tens: char = TEN;
        let mut remainder = 0;
        if exponent == 0 {
            ;
        }
        else if exponent == 1 {
            ones = TEN;
            fives = FIFTY;
            tens = HUNDRED;
        }
        else if exponent == 2 {
            ones = HUNDRED;
            fives = FIVE_HUNDRED;
            tens = THOUSAND;
        }
        else if exponent == 3 {
            ones = THOUSAND;
            fives = '!';
            tens = '!';
        }
        else {
            ones = '!';
            fives = '!';
            tens = '!';
        }
        
        if 9 == digit {
            roman.push(ones);
            roman.push(tens);
        }
        else if 5 <= digit {
            roman.push(fives);
            remainder = digit - 5;
        }
        else if 4 == digit {
            roman.push(ones);
            roman.push(fives);
        }
        else {
            remainder = digit;
        }
        while remainder > 0 {
            roman.push(ones);
            remainder = remainder - 1;
        }
        return roman;
    }
}