/// # Largest Palindrome Product
/// A palindromic number reads the same both ways.
/// The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
///
/// Find the largest palindrome made from the product of two 3-digit numbers.
void main() {
    int largestPalindrome = 0;
    for (int i = 100; i <= 999; i++) {
        for (int j = 100; j <= 999; j++) {
            int product = i * j;
            if (isPalindrome(product) && product > largestPalindrome) {
                largestPalindrome = product;
            }
        }
    }
    println(largestPalindrome);
}

public boolean isPalindrome(int number) {
    String string = Integer.toString(number);
    for (int i = 0; i < string.length(); i++) {
        char front = string.charAt(i);
        char back = string.charAt(string.length() - 1 - i);
        if (front != back) {
            return false;
        }
    }
    return true;
}