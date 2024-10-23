/// # Sum Square Difference
/// The sum of the squares of the first ten natural numbers is:
/// 1^2 + 2^2 + ... + 10^2 = 385
/// The square of the sum of the first ten natural numbers is:
/// (1 + 2 + ... + 10)^2 = 55^2 = 3025
/// Hence the difference between the sum of the squares of the first ten natural numbers
/// and the square of the sum is 3025 - 385 = 2640
/// Find the difference between the sum of the squares of the first one hundred natural numbers
/// and the square of the sum.
void main() {
    println(squareOfSum(100) - sumOfSquares(100));
}

public int sumOfSquares(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i * i;
    }
    return sum;
}

public int squareOfSum(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i;
    }
    return sum * sum;
}