import com.amoalla.euler.utils.Primes;

/// # Summation of primes
/// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
/// Find the sum of all the primes below two million.
void main() {
    long sum = 2;
    for (int i = 3; i < 2000000; i += 2) {
        if (Primes.isPrime(i)) {
            sum += i;
        }
    }
    println(sum);
}