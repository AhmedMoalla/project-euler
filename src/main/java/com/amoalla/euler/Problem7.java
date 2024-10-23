import com.amoalla.euler.utils.Primes;

/// # 10001st Prime
/// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
/// What is the 10001st prime number?
void main() {
    int prime = 2;
    int i = 1;
    while (i <= 10001) {
        if (Primes.isPrime(prime++)) {
            i++;
        }
    }

    println(prime - 1);
}