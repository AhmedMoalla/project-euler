/// # Smallest Multiple
/// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10
/// without any remainder.
///
/// What is the smallest positive number that is evenly divisible by all the numbers from 1
/// to 20?
void main() {
    int number = 1;
    while (!isDivisibleByRange(++number, 1, 20));
    println(number);
}

public boolean isDivisibleByRange(int number, int min, int max) {
    for (int i = min; i <= max; i++) {
        if (number % i != 0) {
            return false;
        }
    }
    return true;
}